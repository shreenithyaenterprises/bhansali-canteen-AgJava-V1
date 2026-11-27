import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '../services/http.service';
import { NotificationService } from '../services/notification.service';
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  disable : boolean =false;
  lstRole= [];
  role:any;
  user_id: string;
  password: string;
  user_name: string;
  cmpy_code: string;
  confirm_password: string;
  userData=[];
  constructor(private httpService: HttpService, private datePipe: DatePipe, private notify: NotificationService) { }

  ngOnInit() {
  this.getRoleList();
  this.getAllUserList();
  this.role='-1';
  }
  getRoleList(){
    this.lstRole=[
      {label: '---SELECT---', value: '-1'},
      {label: 'administrator', value: '0'},
      {label: 'user', value: '1'},

    ]
  }
  submit(){
       // console.log("selectedEmp:"+JSON.stringify(this.selectedEmp))
       var payload = {};
       payload['user_id']=this.user_id;
       payload['password']=this.password;
       payload['role']=this.role;
       payload['user_name']=this.user_name;//localStorage.getItem('deptcode');//this.dept_code.deptcode;
       payload['cmpy_code']='UTCL'//this.reason;
       payload['site']='Dalla'
       console.log(JSON.stringify(payload));
       this.httpService.httpPostService(environment.userProfileSave, payload)
         .subscribe(response => {
           if (response.status == 200) {
             this.notify.showSuccess(response.message);
             //this.VisitorcheckInForm.reset();
             this.reset();
           }
           else {
             this.notify.showError(response.message);
           }
         });
  }
  reset(){
    this.role='-1';
    this.user_id='';
    this.password='';
    this.user_name='';
    this.cmpy_code='';
    this.disable=false;
  }
  getAllUserList(){
    this.userData=[];
    this.httpService.httpGetService(environment.getAllUsers).subscribe(res => {
        this.userData = res.result;
    });
  } 
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deleteUser, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllUserList();
         this.reset();
      } else {
        this.notify.showError(response.message);
      }
    });
  }
  confirmBox(row){
    Swal.fire({
      title: 'Are you sure to Delete?',
      text: 'You will not be able to recover!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.value) {
        this.deleteData(row);
      } 
    })
  }
  editData(editData) {
    this.disable=true;
    this.role=editData.role;
    this.user_id=editData.user_id;
    this.password=editData.password;
    this.confirm_password=editData.password;
    this.user_name=editData.user_name;
    this.cmpy_code=editData.cmpy_code;
 }
}
