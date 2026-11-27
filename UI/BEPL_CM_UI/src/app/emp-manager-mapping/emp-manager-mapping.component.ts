import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { FormBuilder, Validators } from '@angular/forms';
import * as moment from "moment"; 
import { DatePipe } from '@angular/common';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-emp-manager-mapping',
  templateUrl: './emp-manager-mapping.component.html',
  styleUrls: ['./emp-manager-mapping.component.css']
})
export class EmpManagerMappingComponent implements OnInit {
  cols: any[];
  lstemp=[];
  lstempFLTR=[];
  selectedEmp=[];
  optval: string;
  old_mgr: string;
  new_mgr: string;
   constructor(private httpService: HttpService, private fb: FormBuilder, private datePipe: DatePipe, private notify: NotificationService) {
    this.genTableColumns();
    this.optval='SH'
  }

  ngOnInit() {
    this.getManagerDtl();
  }
  genTableColumns() {
    this.cols = [
      { field: 'empCode', header: 'Employee Code', visible: true},
      { field: 'Name', header: 'Employee Name', visible: true },
      { field: 'SH', header: 'SH' , visible: true},
      { field: 'DH', header: 'DH' , visible: true},
      { field: 'FH', header: 'FH' , visible: true},
    ];
  }
  getManagerDtl() {
    this.lstemp=[];
    var payload={};
    payload['emp_code'] = localStorage.getItem('UserId');
    this.httpService.httpGetService(environment.EmpManagerMappingDtl).subscribe(res => {
        this.lstemp = res.result;
        this.lstempFLTR = res.result;
        console.log('lstemp:',this.lstemp); 
    });
  }
  // approve(req_no) {
  //   var payload={};
  //   payload['date_time'] = this.datePipe.transform(moment().toDate(), 'yyyy-MM-dd hh:mm');
  //   payload['req_no'] = req_no;
  //   payload['status'] = '1';
  //   this.httpService.httpPostService(environment.otApproveorReject,payload).subscribe(res => {
  //     this.notify.showSuccess(res.message);
  //     this.getManagerDtl();
  //   });
  // }
  onSearchChange(event){
      if (this.optval==='SH'){
        this.lstempFLTR = this.lstemp.filter(e => e.SH.includes(event.toLowerCase()));
      } else if (this.optval==='DH'){
        this.lstempFLTR = this.lstemp.filter(e => e.DH.includes(event.toLowerCase()));
      }else if (this.optval==='FH'){
        this.lstempFLTR = this.lstemp.filter(e => e.FH.includes(event.toLowerCase()));
      }
  }
  onOptClick(){
    this.lstempFLTR = this.lstemp;
    this.old_mgr='';
  }
  update(){
    var payload = {};
    payload['lstdata'] = this.selectedEmp;
    payload['status'] = this.optval
    payload['emp_code'] = this.new_mgr
    payload['old_mgr'] = this.old_mgr
    console.log(JSON.stringify(payload));
    
    this.httpService.httpPostService(environment.EmpManagerMappingUpdate, payload)
      .subscribe(response => {
        if (response.status == 200) {
          this.notify.showSuccess(response.message +" Affected Rows:"+ response.result);
          //this.VisitorcheckInForm.reset();
        }
        else {
          this.notify.showError(response.message);
        }
      });
  }
}
