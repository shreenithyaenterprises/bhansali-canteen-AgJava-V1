import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import * as XLSX from 'xlsx';
import * as moment from "moment"; 
import { FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-iomissing-report',
  templateUrl: './iomissing-report.component.html',
  styleUrls: ['./iomissing-report.component.css']
})
export class IOMissingReportComponent implements OnInit {

  from_date: any;
  to_date: any;
  constructor(private httpService: HttpService, private fb: FormBuilder,private datePipe: DatePipe) { }

  rptData = [];
  rptFilterData = [];
  ngOnInit(): void {
    this.from_date = this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.to_date =  this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();

    this.getIOMissingList('O');
  }
  getIOMissingList(Status) {
    var opt={};
    var data={};
    this.rptData=[];
    var payload={};
    payload['from_date'] = this.datePipe.transform(this.from_date, 'yyyy-MM-dd');//this.convertDate(startDate)
    payload['to_date'] = this.datePipe.transform(this.to_date, 'yyyy-MM-dd');//this.convertDate(endDate)
  
    this.httpService.httpPostService(environment.getIOMissingReport,payload).subscribe(res => {
      this.rptData = res.result;
      this.rptFilterData= res.result;
    });
  }
  exportexcel(): void {
    let element = document.getElementById('visitor-report');
    const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Summary Data');
    XLSX.writeFile(wb, 'IO Missing Report.xlsx');
  }
  getReport(){
    this.getIOMissingList('');
  }
  applyFilter(filterValue: string) {
    //debugger;
    //this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.rptFilterData= this.rptData
    } else  {
       this.rptFilterData = this.rptData.filter((emp) => 
                        emp.EmployeesCode && emp.EmployeesCode.toLowerCase().includes(filterValueLower) || 
                        emp.name && emp.name.toLowerCase().includes(filterValueLower)); 

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
