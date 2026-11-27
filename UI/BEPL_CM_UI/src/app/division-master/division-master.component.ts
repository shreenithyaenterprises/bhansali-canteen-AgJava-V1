import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-division-master',
  templateUrl: './division-master.component.html',
  styleUrls: ['./division-master.component.css']
})
export class DivisionMasterComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  divisionData = [];
  disable : boolean =false;
  ngOnInit() {
    this.getAllDivisionList();
  }
  DivisionMasterForm = this.fb.group({
    division_code: ["", Validators.required],
    division_name: ["", Validators.required]

  });
  
  get division_code(){ return this.DivisionMasterForm.get('division_code'); }
  get division_name(){ return this.DivisionMasterForm.get('division_name'); }

  editData(editData) {
    this.disable =true;
    this.DivisionMasterForm.patchValue({
      division_code: editData.division_code,
      division_name: editData.division_name
    });
  }

  deleteData(Data) {
    this.httpService
    .httpPostService(environment.DivisionDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllDivisionList();
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
    this.saveData(this.DivisionMasterForm.value);
  }
  saveData(divMas) {
    if (divMas) {
      this.httpService
        .httpPostService(environment.DivisionMasterSave, divMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this. getAllDivisionList();
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  reset(){
    this.DivisionMasterForm.reset();
    this.disable =false;
  }
  getAllDivisionList(){
    this.divisionData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllDivision).subscribe(res => {
        this.divisionData = res.result;
    });
  }

}
