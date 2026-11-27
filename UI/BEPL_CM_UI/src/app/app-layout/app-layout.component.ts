import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CodeNode } from 'source-list-map';


declare const App :any;
@Component({
  selector: 'app-app-layout',
  templateUrl: './app-layout.component.html',
  styleUrls: ['./app-layout.component.css']
})
export class AppLayoutComponent implements OnInit {

 userName : string;
 userId : string;
 deptCode: string;
 deptName: string;
 role : string;
 rf : string;
 companyName : string;
 user_menu: [];
 items;
  constructor(private router:Router) { }

  ngOnInit() {
   this.userName=localStorage.getItem('userName');
   this.userId=localStorage.getItem('UserId');
   this.role=localStorage.getItem('role');
   this.deptName=localStorage.getItem('deptName');
   this.deptCode=localStorage.getItem('deptCode');
   this.user_menu=JSON.parse(localStorage.getItem('menu'))||[];
   this.rf=localStorage.getItem('rf');
   //this.refresh();
   //var companyDetails =JSON.parse(localStorage.getItem('companyDetails'));
   //this.companyName=companyDetails['cmpy_name'];
}
refresh(): void {
    if (this.rf=='0'){
        window.location.reload();
        localStorage.setItem('rf','1');
    }
 }
  signOut(){
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
