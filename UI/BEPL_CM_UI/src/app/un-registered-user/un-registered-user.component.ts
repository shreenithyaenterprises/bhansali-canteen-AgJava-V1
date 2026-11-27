import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import * as XLSX from 'xlsx';
import { FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-un-registered-user',
  templateUrl: './un-registered-user.component.html',
  styleUrls: ['./un-registered-user.component.css']
})
export class UnRegisteredUserComponent implements OnInit {

  from_date: any;
  to_date: any;
  dept: string;
  deptName: string;
  departmentList=[];
  rptData = [];
  rptFilterData =[];
  cols=[];
  constructor(private httpService: HttpService, private fb: FormBuilder,private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.from_date = new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.to_date =   new Date().toISOString().slice(0, 10);//this.convertDate(this.datePipe.transform(moment().toDate(), 'dd-MM-yyyy'));//moment().toDate();
    this.genTableColumns();
    this.getUnRegisteredUsers();
  }
  genTableColumns() {
    this.cols = [
      { field: 'create_time', header: 'Creation Date', visible: true, width: '70px', data: true, format: 'dd-MM-yyyy'},
      { field: 'emp_code', header: 'Emp Code', visible: true, width: '70px'},
      { field: 'first_name', header: 'Name', visible: true, width: '200px'},
      { field: 'site_name', header: 'Site' , visible: true, width: '200px'},
    ];
  }
  getUnRegisteredUsers() {
    this.rptData=[];
    var payload={};
    
    if (localStorage.getItem('role')=='1'){
      payload['site']=localStorage.getItem('site')
    }
    payload['from_date'] = this.datePipe.transform(this.from_date, 'yyyy-MM-dd');//this.convertDate(startDate)
    payload['to_date'] = this.datePipe.transform(this.to_date, 'yyyy-MM-dd');//this.convertDate(endDate)
    //payload['deptcode'] = this.dept;
    this.httpService.httpPostService(environment.getUnregisteredUser,payload).subscribe(res => {
      this.rptData = res.result;
    });
  }
}
