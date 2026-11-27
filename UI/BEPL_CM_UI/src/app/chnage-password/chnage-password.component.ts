import { Component, OnInit } from '@angular/core';
import { NotificationService } from "../services/notification.service";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { Router } from '@angular/router';

@Component({
  selector: 'app-chnage-password',
  templateUrl: './chnage-password.component.html',
  styleUrls: ['./chnage-password.component.css']
})
export class ChnagePasswordComponent implements OnInit {
  password: any;
  confirm_password: any;
  constructor( private httpService: HttpService, private notify: NotificationService, private router:Router) { }

  ngOnInit() {
  }
  changePassword(){
   
    if(this.password != this.confirm_password) {
      //this.confirm_password.setCustomValidity("Passwords Don't Match");
      this.notify.showError('Password and Confirm password doesn\'t Match'); 
      return false;
    } 
    var payload={};
    payload['user_id'] = localStorage.getItem('UserId');
    payload['password'] = this.password;
    this.httpService.httpPostService(environment.resetPassword,payload).subscribe(res => {
      if (res.result=='Success'){
        this.notify.showSuccess(res.result); 
        this.router.navigate(['/login']);
      } else{
        this.notify.showError(res.result); 
      }
      
    });
   
  }

}
