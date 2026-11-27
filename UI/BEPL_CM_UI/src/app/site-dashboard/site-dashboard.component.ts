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
  selector: 'app-site-dashboard',
  templateUrl: './site-dashboard.component.html',
  styleUrls: ['./site-dashboard.component.css']
})
export class SiteDashboardComponent implements OnInit {

  IOCount : any ={};
  summaryData =[];
  summaryDataMonthly =[];
  rmd: number=0;
  IOData=[];
  SiteData=[];
  dtlData=[];
  dtlFLTRData=[];
  selectedOPT:any;
  sites={};
  IOFilterData=[];
  optbtn: any;
  optFLTR:boolean=false;
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
  rf:any;
  dtpicker:any;
  public height: number;
  public width: number;
  public type = 'PieChart';
  public title;
  emData = [];
  _object = Object;
  private updateSubscription: Subscription;
  constructor( private datePipe: DatePipe, private httpService: HttpService, private notify: NotificationService) 
  { }
  ngOnInit() {
    this.dtpicker=new Date().toISOString().split('T')[0];
    this.rf=localStorage.getItem('rf');
    this.refresh();
    this.getMealCountAllSite();
    this.getMealsSummaryDaily();
    this.getMealsSummaryMonthly();
    this.getMealsDetailData();
    this.showAlert();
    // this.updateSubscription = interval(10000*6).subscribe(
    //   (val) => { 
    //     this.getMealCountAllSite();
    //     this.getMealsSummaryDaily();
    //     this.getMealsSummaryMonthly();
    // });

  //  this.getAllEMContactList();
  }
  showAlert(){
    this.rmd =((localStorage.getItem('rmd') as unknown) as number);
    if( this.rmd <= 15) 
    {
       this.notify.showError('Your License will expire in '+this.rmd +' days. Please renew before it expires!')
    }
  }
  refresh(): void {
    if (this.rf=='0'){
        window.location.reload();
        localStorage.setItem('rf','1');
    }
 }
  // ngOnDestroy() {
  //   this.updateSubscription.unsubscribe();
  // }
  dateChange(e){
    this.getMealsSummaryDaily();
    this.getMealCountAllSite();
    this.getMealsDetailData();
   }
  getMealCountAllSite() {
     var payLoad={};
     payLoad['site'] =localStorage.getItem('site');
     payLoad['date']=this.dtpicker;
     this.httpService.httpPostService(environment.getMealCountAllSite,payLoad).subscribe(res => {
        this.SiteData = res.result;
    }); 
  }
  
  getMealsSummaryMonthly() {
    var payLoad={};
    payLoad['site'] =localStorage.getItem('site');
    payLoad['role'] =localStorage.getItem('role')
      this.httpService.httpPostService(environment.getMealsSummaryMonthly,payLoad).subscribe(res => {
         this.summaryDataMonthly = res.result;
         console.log('summaryDataMonthly::',this.summaryDataMonthly);
     });
   }
   getMealsSummaryDaily() {
      var payLoad={};
      payLoad['site'] =localStorage.getItem('site');
      payLoad['date']=this.dtpicker;

      this.httpService.httpPostService(environment.getMealsSummaryDaily,payLoad).subscribe(res => {
         this.summaryData = res.result;
         this.MealsChart();
     });
   }

   getMealsDetailData() {
    this.dtlData=[];
    this.dtlFLTRData=[];
    var payLoad={'site':null};
    payLoad.site =localStorage.getItem('site');
      this.httpService.httpPostService(environment.getMealsDetail, payLoad).subscribe(res => {
         this.dtlData = res.result;
         this.dtlFLTRData =res.result;
         console.log('this.dtlData',JSON.stringify(this.dtlData));
     });
   }
  // Card Detail View 
  DetailView(opt,rowData) {
    debugger;
    this.optbtn=-1;
    this.optFLTR=true;
      //this.getMealsDetailData();
      this.selectedOPT=opt;
      let filterValueLower = opt.toLowerCase();
      this.dtlData=[];
      this.dtlFLTRData=[];
      var payLoad={'site':null};
      payLoad.site =localStorage.getItem('site');
        this.httpService.httpPostService(environment.getMealsDetail, payLoad).subscribe(res => {
           this.dtlData = res.result;
           this.dtlFLTRData =res.result;
           //console.log('this.dtlData',JSON.stringify(this.dtlData));
           if(opt === '' )
           {
               this.dtlFLTRData= this.dtlData
           } else  {
              this.dtlFLTRData = this.dtlData.filter((data) => 
                               (data.meal_code && data.meal_code.toLowerCase().includes(filterValueLower)) && 
                               (data.site_code && data.site_code.toLowerCase().includes(rowData.site_code.toLowerCase()))
                               ); 
           }

       });

      this.dialogDisplay = true;
  }
  //Monthly Summary Table  View
  DetailViewMonthly(rowData) {
    this.optbtn=-1;
    this.optFLTR=false;
    this.dtlData=[];
    this.dtlFLTRData=[];
    var payLoad={'catcode':null,'site':null};
    payLoad.site =localStorage.getItem('site');
    payLoad.catcode=rowData.catcode;
    this.httpService.httpPostService(environment.getMealsDetailMonthly,payLoad).subscribe(res => {
      this.dtlData = res.result;
      this.dtlFLTRData = res.result;
    });
    this.dialogDisplay = true;
  }
  // Option button Selection
  onChange(value){
    let site=localStorage.getItem('site').toLowerCase();
    let opt =this.selectedOPT.toLowerCase();
    debugger;
    if (value == 'EMP'){
       this.dtlFLTRData = this.dtlData.filter((data) => 
       //(data.emp_site && data.emp_site.toLowerCase().includes(site)) &&
       (data.emp_type && data.emp_type.toLowerCase()=='emp') &&
       (data.meal_code && data.meal_code.toLowerCase().includes(opt))
       );
       return;
    } else if (value== 'VDR'){
      this.dtlFLTRData = this.dtlData.filter((data) => 
      //(data.emp_site && data.emp_site.toLowerCase().includes(site)) &&
      (data.emp_type && data.emp_type.toLowerCase()=='vdr') &&
      (data.meal_code && data.meal_code.toLowerCase().includes(opt))
      );
      return;
    } else if (value== 'VIS'){
      this.dtlFLTRData = this.dtlData.filter((data) => 
      //(data.emp_site && data.emp_site.toLowerCase().includes(site)) &&
      (data.emp_type && data.emp_type.toLowerCase()=='vis') &&
      (data.meal_code && data.meal_code.toLowerCase().includes(opt))
      );
      return;
    } else if (value== 'OEMP'){
      this.dtlFLTRData = this.dtlData.filter((data) => 
      //(data.emp_site && data.emp_site.toLowerCase().includes(site)) &&
      (data.emp_type && data.emp_type.toLowerCase()=='oemp') &&
      (data.meal_code && data.meal_code.toLowerCase().includes(opt))
      );
      return;
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
