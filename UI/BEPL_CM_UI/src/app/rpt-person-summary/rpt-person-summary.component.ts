import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import * as XLSX from 'xlsx';
import * as moment from "moment"; 
import { FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-rpt-person-summary',
  templateUrl: './rpt-person-summary.component.html',
  styleUrls: ['./rpt-person-summary.component.css']
})
export class RptPersonSummaryComponent implements OnInit {

  from_date: any;
  to_date: any;
  emp: string;
  empName: string;
  EmpList=[];
  rptData = [];
  rptFilterData =[];
  employeeData=[];
  cols=[];
  constructor(private httpService: HttpService, private fb: FormBuilder,private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.from_date = new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.to_date =   new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.genTableColumns();
    this.getAllEmployeeList();
    this.emp="-1"
  }
  genTableColumns() {
    this.cols = [
      { field: 'punch_date', header: 'Date', visible: true, width: '70px', data: true, format: 'dd-MM-yyyy'},
      { field: 'emp_code', header: 'Emp Code', visible: true, width: '70px'},
      { field: 'name', header: 'Name', visible: true, width: '120px'},
      { field: 'department', header: 'Department' , visible: true, width: '70px'},
      { field: 'category', header: 'Category' , visible: true, width: '70px'},
      { field: 'division_name', header: 'Division' , visible: true, width: '70px'},
      { field: 'contname', header: 'Contractor' , visible: true, width: '70px'},
      { field: 'TEA', header: 'TEA' , visible: true, width: '70px'},
      { field: 'lunch', header: 'Lunch' , visible: true, width: '80px'},
      // { field: 'snacks', header: 'Snacks' , visible: true, width: '70px'},
      { field: 'dinner', header: 'Dinner' , visible: true, width: '70px'},
      //{ field: 'mns', header: 'Midnight Snacks' , visible: true, width: '70px'},
      //{ field: 'tea', header: 'Tea' , visible: true, width: '70px'},
      { field: 'uc', header: 'Unknown' , visible: true, width: '70px'},
    ];
  }
  getMealsSummaryList() {
    this.rptData=[];
    var payload={};
    
    if (localStorage.getItem('role')=='1'){
      payload['site']=localStorage.getItem('site')
    }
    payload['from_date'] = this.datePipe.transform(this.from_date, 'yyyy-MM-dd');//this.convertDate(startDate)
    payload['to_date'] = this.datePipe.transform(this.to_date, 'yyyy-MM-dd');//this.convertDate(endDate)
    payload['emp_code'] = this.emp;

    this.httpService.httpPostService(environment.getPersonSummarybyDate,payload).subscribe(res => {
      this.rptData = res.result;
      this.rptFilterData = res.result;
    });
  }
  getdepartmentList() {
    this.httpService
      .httpGetService(environment.getAllEmployee)
      .subscribe(res => {
        this.EmpList = res.result; 
      });
  }
  getAllEmployeeList(){
    this.EmpList=[];
    var payload={};
    var url=environment.getAllEmployee;
    if (localStorage.getItem('role')=='1'){
      payload['site']=localStorage.getItem('site')
      url=environment.getAllEmployeeBySite;
    }
    this.httpService.httpPostService(url,payload).subscribe(res => {
        this.EmpList = res.result;
        this.EmpList.sort(this.sortOn("empname"));
    });
 } 
  onEmpChange($event){
    this.empName = $event.target.options[$event.target.options.selectedIndex].text;
    this.getMealsSummaryList();
  }
  exportexcel(): void {
    let element = document.getElementById('report');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    //XLSX.utils.sheet_add_json(ws, this.rptData, { origin: 'A2', skipHeader: true });
    XLSX.utils.book_append_sheet(wb, ws, 'Summary Data');
    XLSX.writeFile(wb, 'Summary Report.xlsx');
  }
  getReport(){
    this.getMealsSummaryList();
  }
  applyFilter(filterValue: string) {
    //debugger;
    //this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.rptFilterData= this.rptData
    } else  {
       this.rptFilterData = this.rptData.filter((x) => 
        x.emp_code && x.emp_code.toLowerCase().includes(filterValueLower) || 
        x.emp_site && x.emp_site.toLowerCase().includes(filterValueLower) || 
        x.site_name && x.site_name.toLowerCase().includes(filterValueLower) || 
        x.meal && x.meal.toLowerCase().includes(filterValueLower) || 
        x.emp_site && x.emp_site.toLowerCase().includes(filterValueLower) || 
        x.emp_type && x.emp_type.toLowerCase().includes(filterValueLower) || 
        x.area_description && x.area_description.toLowerCase().includes(filterValueLower) || 
        x.name && x.name.toLowerCase().includes(filterValueLower)); 

    }
 }
  convertDate(strDate){
    const [day, month, year] = strDate.split('-');
      console.log(day); // 👉️ 22
      console.log(month); // 👉️ 04
      console.log(year); // 👉️ 2022
    const date = new Date(+year, month - 1, +day);
    return date;
  }
  sortOn(property){
    return function(a, b){
        if(a[property] < b[property]){
            return -1;
        }else if(a[property] > b[property]){
            return 1;
        }else{
            return 0;   
        }
    }
}


}
