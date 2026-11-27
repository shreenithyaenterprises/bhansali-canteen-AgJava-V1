import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import * as XLSX from 'xlsx';
import * as moment from "moment"; 
import { FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-rpt-meals-aggregate',
  templateUrl: './rpt-meals-aggregate.component.html',
  styleUrls: ['./rpt-meals-aggregate.component.css']
})
export class RptMealsAggregateComponent implements OnInit {

  from_date: any;
  to_date: any;
  meal: string;
  mealName: string;
  MealList=[];
  rptData = [];
  rptFilterData =[];
  category:any;
  catList =[];
  constructor(private httpService: HttpService, private fb: FormBuilder,private datePipe: DatePipe) {
    this.meal="-1"
    this.category="-1"
  }

  ngOnInit(): void {
    this.from_date = new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.to_date =   new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
   // this.getMealsList();
   // this.getAllCategoryList();
   // this.getMealsSummaryList();
  }
  getMealsSummaryList() {

    this.rptData=[];
    this.rptFilterData=[];
    var payload={};

    if (localStorage.getItem('role')=='1') {
      payload['site']=localStorage.getItem('site')
    }
    payload['from_date'] = this.datePipe.transform(this.from_date, 'yyyy-MM-dd');//this.convertDate(startDate)
    payload['to_date'] = this.datePipe.transform(this.to_date, 'yyyy-MM-dd');//this.convertDate(endDate)
    payload['role'] = localStorage.getItem('role');
    payload['catcode']=this.category;

    this.httpService.httpPostService(environment.getMealAggregate,payload).subscribe(res => {
      this.rptData = res.result;
      this.rptFilterData = res.result;
    });
  }
  getAllCategoryList(){
    this.catList=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllCategory).subscribe(res => {
        this.catList = res.result;
    });
  }
  onRBChange(val) {
    this.category=val;
    this.getMealsSummaryList();
  }
  onItemChange($event){
    //this.mealName = $event.target.options[$event.target.options.selectedIndex].text;
    this.getMealsSummaryList();
  }
  exportexcel(): void {
    let element = document.getElementById('report');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
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



}
