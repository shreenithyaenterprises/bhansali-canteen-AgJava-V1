import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-site-master',
  templateUrl: './site-master.component.html',
  styleUrls: ['./site-master.component.css']
})
export class SiteMasterComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  SiteData = [];
  disable : boolean =false;
  ngOnInit() {
    this.getAllSiteList();
  }
  SiteMasterForm = this.fb.group({
    site_code: ["", Validators.required],
    site_name: ["", Validators.required]

  });

  get site_code(){ return this.SiteMasterForm.get('site_code'); }
  get site_name(){ return this.SiteMasterForm.get('site_name'); }

  editData(editData) {
    this.disable =true;
    this.SiteMasterForm.patchValue({
      site_code: editData.site_code,
      site_name: editData.site_name
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.siteMasterDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllSiteList();
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
  Submit() {
    this.saveData(this.SiteMasterForm.value);
  }
  saveData(SiteMas) {
    if (SiteMas) {
      this.httpService
        .httpPostService(environment.siteMasterSave, SiteMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllSiteList();
             this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  reset(){
    this.disable =false;
    this.SiteMasterForm.reset();
  }
  getAllSiteList(){
    this.SiteData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllsite).subscribe(res => {
        this.SiteData = res.result;
    });
  }
}
