import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js'; 
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {

  deviceData =[];
  IOlist =[];
  siteList =[];
  establishmentList =[];
  currentDateTime : string="";
  disable : boolean =false;
  datePickerConfig = {
    drops: 'down',
    format: 'DD/MM/YYYY',
    todayText: 'Oggi',
    style: 'big'
  }
  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  
  ) {
     this.currentDateTime = formatDate(new Date(), 'dd/MM/yyyy', 'en');
     console.log('Current Date:', this.currentDateTime);
  } 
  ngOnInit() {
    this.getAllDeviceList();
    this.getIOList();
    this.getAllSiteList();
  }
  
  DeviceForm = this.fb.group({
    ip_address: ["", Validators.required],
    machine_no: ["", Validators.required],
   // location: [""],
    area_code: ["", Validators.required],
    area_name: ["", Validators.required],
    used_for_ic: [""],
    in_out: ["I", Validators.required],
    face_reader: [""],
    rf_id: [""],
    site_code: [""],
  });
  getIOList(){
    this.IOlist=[
      {"code":"I","name":"In"},
      {"code":"O","name":"Out"},
      {"code":"B","name":"Both"},
      {"code":"NA","name":"NA"},
    ];
  }
  get ip_address(){ return this.DeviceForm.get('ip_address'); }
  get machine_no(){ return this.DeviceForm.get('machine_no'); }
  //get location(){ return this.DeviceForm.get('location'); }
  get area_code(){ return this.DeviceForm.get('area_code'); }
  get site_code(){ return this.DeviceForm.get('site_code'); }
  get area_name(){ return this.DeviceForm.get('area_name'); }
  get used_for_ic(){ return this.DeviceForm.get('used_for_ic'); }
  get in_out(){ return this.DeviceForm.get('in_out'); }
  get face_reader(){ return this.DeviceForm.get('face_reader'); }
  get rf_id(){ return this.DeviceForm.get('rf_id'); }

  editData(editData) {
    this.disable =true;
      this.DeviceForm.patchValue({
        ip_address: editData.ip_address,
        machine_no: editData.machine_no,
        //location: editData.location,
        area_code: editData.area_code,
        site_code: editData.site_code,
        area_name: editData.area_name,
        used_for_ic: editData.used_for_ic,
        in_out: editData.in_out,
        face_reader: editData.face_reader,
        rf_id: editData.rf_id
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deletedevicebyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllDeviceList();
         this.ResetForm();
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
    this.saveData(this.DeviceForm.value);
  }
  saveData(shift) {
    if (shift) {
      this.httpService
        .httpPostService(environment.deviceSave, shift)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllDeviceList();
            this.ResetForm();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  ResetForm(){
    this.disable =false;
    this.DeviceForm.reset();
    this.DeviceForm.patchValue({in_out: "I"});
    this.DeviceForm.patchValue({site_code: ""});
  }
  getAllDeviceList(){
    this.deviceData=[];
    var payload={};
    var url=environment.getAlldevice
    if (localStorage.getItem('role')=='1'){
      payload['site']=localStorage.getItem('site')
      url=environment.getAlldevicebySite;
    }
    this.httpService.httpPostService(url,payload).subscribe(res => {
        this.deviceData = res.result;
    });
  }
  getAllSiteList(){
    this.siteList=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllsite).subscribe(res => {
        this.siteList = res.result;
    });
  }
}
