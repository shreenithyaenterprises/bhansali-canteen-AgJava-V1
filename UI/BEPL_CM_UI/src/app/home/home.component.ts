import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { Observable, interval, Subscription } from 'rxjs';
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import * as moment from "moment"; 
import * as XLSX from 'xlsx';
import { DatePipe } from '@angular/common';
import { inherits } from 'util';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  IOCount : any ={};
  rmd: number=0;
  summaryData =[];
  summaryDataMonthly =[];
  IOData=[];
  SiteData=[];
  dtlData=[];
  dtlFLTRData=[];
  sites={};
  IOFilterData=[];
  rf : string;
  SMRYData=[];
  SMRYFilterData=[];
  AreawiseData=[];
  DeptwiseData=[];
  ContwiseData=[];
  ShiftwiseData=[];
  public columnNames: string[];
  dialogDisplay: boolean = false;
  IO: boolean = false;
  public options: {};
  public height: number;
  public width: number;
  public type = 'PieChart';
  public title;
  dtpicker:any;
  emData = [];
  _object = Object;
  private updateSubscription: Subscription;
  constructor( private datePipe: DatePipe, private httpService: HttpService, private notify: NotificationService) 
  { }
  ngOnInit() {
    this.dtpicker=new Date().toISOString().split('T')[0];
    this.getMealCountAllSite();
    this.getMealsSummaryDaily();
    this.getMealsSummaryMonthly();
    this.getMealsDetailData();
    this.showAlert();
    this.rf=localStorage.getItem('rf');
    this.refresh();
    // this.updateSubscription = interval(10000*6).subscribe(
    //   (val) => { 
    //     this.getMealCountAllSite();
    //     this.getMealsSummaryDaily();
    //     this.getMealsSummaryMonthly();
    //     this.getMealsDetailData();
    // });
  }
  refresh(): void {
    if (this.rf=='0'){
        window.location.reload();
        localStorage.setItem('rf','1');
    }
 }
  ngOnDestroy() {
   // this.updateSubscription.unsubscribe();
 }
 dateChange(e){
  this.getMealsSummaryDaily();
  this.getMealCountAllSite();
  this.getMealsDetailData();
 }
 showAlert(){
  this.rmd =((localStorage.getItem('rmd') as unknown) as number);
  if( this.rmd <= 15) 
  {
     this.notify.showError('Your License will expire in '+this.rmd +' days. Please renew before it expires!')
  }
}
  getMealCountAllSite() {
     var payLoad={};
     payLoad['date']=this.dtpicker;
     this.httpService.httpPostService(environment.getMealCountAllSite,payLoad).subscribe(res => {
        this.SiteData = res.result;
    }); 
  }
  
  getMealsSummaryMonthly() {
      var payLoad={};
      payLoad['role']=localStorage.getItem('role')
      this.httpService.httpPostService(environment.getMealsSummaryMonthly,payLoad).subscribe(res => {
         this.summaryDataMonthly = res.result;
     });
   }
   getMealsSummaryDaily() {
      var payLoad={};
      payLoad['date']=this.dtpicker;
      this.httpService.httpPostService(environment.getMealsSummaryDaily,payLoad).subscribe(res => {
         this.summaryData = res.result;
         this.MealsChart();
     });
   }
   getMealsDetailData() {
      var payLoad={};
      payLoad['date']=this.dtpicker;
      this.dtlData =[];
      this.httpService.httpPostService(environment.getMealsDetail, payLoad).subscribe(res => {
         this.dtlData = res.result;
         this.dtlFLTRData =res.result;
     });
   }
  DetailView(opt,rowData) {
      let filterValueLower = opt.toLowerCase();
      if(opt === '' )
      {
          this.dtlFLTRData= this.dtlData
      } else  {
         this.dtlFLTRData = this.dtlData.filter((data) => 
                          (data.meal_code && data.meal_code.toLowerCase().includes(filterValueLower)) && 
                          (data.site_code && data.site_code.toLowerCase().includes(rowData.site_code.toLowerCase()))); 
                         // emp.mobile && emp.mobile.includes(filterValueLower));
      }
      this.dialogDisplay = true;
  }
  DetailViewMonthly(rowData) {
    var payLoad={'site':null};
    payLoad.site=rowData.site_code;
    this.httpService.httpPostService(environment.getMealsDetailMonthly,payLoad).subscribe(res => {
      this.dtlData = res.result;
      this.dtlFLTRData = res.result;
      console.log(this.dtlFLTRData);
    });
    this.dialogDisplay = true;
  }

  getAllEMContactList(){
    this.emData=[];
    this.httpService.httpGetService(environment.getAllDetails).subscribe(res => {
        this.emData = res.result;
    });
  }

  getIOCountDeptWise() {
   // this.IOCount={};
     this.httpService.httpGetService(environment.getIOCountDeptWise).subscribe(res => {
        this.DeptwiseData = res.result;
    });
  }
  getIOCountContWise() {
   // this.IOCount={};
     this.httpService.httpGetService(environment.getIOCountContWise).subscribe(res => {
        this.ContwiseData = res.result;
    });
  }
  applyFilter(filterValue: string) {
    //debugger;
    //this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.SMRYFilterData= this.SMRYData
    } else  {
       this.SMRYFilterData = this.SMRYData.filter((emp) => 
                        emp.EmployeesCode && emp.EmployeesCode.toLowerCase().includes(filterValueLower) || 
                        emp.name && emp.name.toLowerCase().includes(filterValueLower)); 
                       // emp.mobile && emp.mobile.includes(filterValueLower));
    }
 }
 applyFilterIO(filterValue: string) {
  let filterValueLower = filterValue.toLowerCase();
  if(filterValue === '' )
  {
      this.IOFilterData= this.IOData
  } else  {
     this.IOFilterData = this.IOData.filter((emp) => 
                      emp.EmployeesCode && emp.EmployeesCode.toLowerCase().includes(filterValueLower) || 
                      emp.name && emp.name.toLowerCase().includes(filterValueLower)); 
                     // emp.mobile && emp.mobile.includes(filterValueLower));
  }
}
  exportexcel(): void {
    let element = document.getElementById('punches-report');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'HeadCount Data');
    XLSX.writeFile(wb, 'HeadCount Report.xlsx');
  }
  MealsChart() {
    let ar: any[] = new Array();
       // let keys = Object.keys(this.AreaWiseCount);
        for (let result of this.summaryData) {
          var temp = [
            result.meal,
            result.meal_count
           
          ];
          ar.push(temp);
        }

        //console.log(ar);
        //this.title = 'In/Out Counts';
        //this.type = 'PieChart';
        this.summaryData = ar;
        this.columnNames = ['meal', 'meal_count'];
        this.options = {
          title: 'Meals Count',
          is3D: true,
          pieHole: 0.4,
          'width':400,
          'height':300,
          backgroundColor: {
            fill: 'transparent',
            fillOpacity: 0.8
          },
          titleTextStyle: {
            color: 'white'
          },
          legend: {
          textStyle: {
              color: 'white'
            }
          },
          animation:{
						duration: 1000,
						easing: 'out',
						startup: true
					},
          chartArea: {
            left: "2%",
            top: "2%",
            height: "98%",
            width: "98%"
          },
          colors: ['#DE3163', '#0400FF','#6495ED', '#DFFF00','#FFC300','#008000','#800080','#00FF00','#FF0000'],
          
        };

      
  }
}
