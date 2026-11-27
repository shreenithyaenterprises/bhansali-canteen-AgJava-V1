import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';


@Component({
  selector: 'app-designation-master',
  templateUrl: './designation-master.component.html',
  styleUrls: ['./designation-master.component.css']
})
export class DesignationMasterComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  designationData = [];
  disable : boolean =false;

  ngOnInit() {
    this.getAllDesignationList();
  }
  DesignationMasterForm = this.fb.group({
    designation_code: ["", Validators.required],
    designation_name: ["", Validators.required]

  });
  
  get designation_code(){ return this.DesignationMasterForm.get('designation_code'); }
  get designation_name(){ return this.DesignationMasterForm.get('designation_name'); }

  editData(editData) {
    this.disable =true;
    this.DesignationMasterForm.patchValue({
      designation_code: editData.designation_code,
      designation_name: editData.designation_name
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.DesignationDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllDesignationList();
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
    this.saveData(this.DesignationMasterForm.value);
  }
  saveData(desgnMas) {
    if (desgnMas) {
      this.httpService
        .httpPostService(environment.DesignationMasterSave, desgnMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllDesignationList();
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllDesignationList(){
    this.designationData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllDesignation).subscribe(res => {
        this.designationData = res.result;
    });
  }
  reset(){
    this.disable =false;
    this.DesignationMasterForm.reset();
  }
}
