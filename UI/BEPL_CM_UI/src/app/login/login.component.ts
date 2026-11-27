import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, Validators, FormControl } from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  dialogDisplay: boolean = false;
  login_id: any;
  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService,
    private router:Router,
    
  ) {}

  ngOnInit() {
  }
  userForm = this.fb.group({
    userid: ["", Validators.required],
    password: ["", Validators.required],
  });
  Submit() {
    this.userLogin(this.userForm.value);
  }
  showDialog() {
    this.dialogDisplay=true;
  }
  forgotPassword(){
  //  alert(this.login_id)
    var payload={};
    payload['user_id'] = this.login_id;
    this.httpService.httpPostService(environment.forgotPassword,payload).subscribe(res => {
      this.notify.showInfo(res.result); 
    });
  }
  userLogin(user) {
    if (user) {
     // debugger;
      this.httpService
        .httpPostService(environment.userLogin, user)
        .subscribe(response => {
          if (response.status == 200) {
            var userDetails=response.result;//JSON.stringify(response.result);
            localStorage.setItem('UserId',userDetails['user_id']);
            localStorage.setItem('role',userDetails['role']);
            localStorage.setItem('userName',userDetails['user_name']);
            localStorage.setItem('menu',userDetails['menu_text']);
            localStorage.setItem('deptcode',userDetails['deptcode']);
            localStorage.setItem('deptName',userDetails['department']);
            if(userDetails['role']==0)
            {
              localStorage.setItem('site',null);
            } else {
              localStorage.setItem('site',userDetails['site']);
            }
            localStorage.setItem('rmd',userDetails['days']);
            localStorage.setItem('rf','0');
            localStorage.setItem('password_change', userDetails['password_change']);
            if (userDetails['password_change']=='1') {
              this.router.navigate(['/ChangePassword']);
            } else {
              if (userDetails['role']==0){
                this.router.navigate(['/home']);
              } else if(userDetails['role']==1) {
                this.router.navigate(['/Sitedsb']);
              }
            }
           // this.router.navigate(['/index.html']);
          } else if (response.status == 402) {
            this.notify.showError(response.message);
          }else {
            this.notify.showError(response.message);
          }
        },
        err =>{
          this.notify.showError(err.status+" "+ err.error);
          //this.notify.showError(JSON.stringify(err));
         }
        );
    }
  }
}
