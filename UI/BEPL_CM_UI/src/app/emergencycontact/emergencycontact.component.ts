import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";

@Component({
  selector: 'app-emergencycontact',
  templateUrl: './emergencycontact.component.html',
  styleUrls: ['./emergencycontact.component.css']
})
export class EmergencycontactComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  emData = [];
  lstShift =[];

  ngOnInit() {
    this. getAllEMContactList();
    this.getShiftList();
  }
  emForm = this.fb.group({
    name: ["", Validators.required],
    mobile_no: ["", Validators.required],
    assembly_point: ["", Validators.required],
    shift: ["-1", Validators.required]

  });
  get name(){ return this.emForm.get('name'); }
  get mobile_no(){ return this.emForm.get('mobile_no'); }
  get assembly_point(){ return this.emForm.get('assembly_point'); }
  get shift(){ return this.emForm.get('shift'); }

  editData(editData) {
    this.emForm.patchValue({
      name: editData.name,
      mobile_no: editData.mobile_no,
      assembly_point: editData.assembly_point,
      shift: editData.shift,
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deleteEmConactbyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllEMContactList();
        // this.SendSMSForm.reset();
      } else {
        this.notify.showError(response.message);
      }
    });
 }
  Submit() {
    this.saveData(this.emForm.value);
  }
  Reset() {
    this.emForm.reset();
  }
  saveData(emData) {
    if (emData) {
      this.httpService
        .httpPostService(environment.emContactSave, emData)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.emForm.reset();
            this.getAllEMContactList();
            // this.SendSMSForm.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllEMContactList(){
    this.emData=[];
    this.httpService.httpGetService(environment.getAllDetails).subscribe(res => {
        this.emData = res.result;
    });
  }
  getShiftList(){
    this.lstShift=[
      {label: '---SELECT---', value: '-1'},
      {label: 'A', value: 'AA'},
      {label: 'B', value: 'BB'},
      {label: 'C', value: 'CC'},
      {label: 'G', value: 'GN'},
    ]
  }
}
