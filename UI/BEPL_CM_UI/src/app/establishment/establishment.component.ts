import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-establishment',
  templateUrl: './establishment.component.html',
  styleUrls: ['./establishment.component.css']
})
export class EstablishmentComponent implements OnInit {
  disable : boolean =false;
  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  EstablishmentData = [];
  ngOnInit() {
    this.getAllEstablishmentList();
  }
  EstablsihmentForm = this.fb.group({
    code: ["", Validators.required],
    establishment: ["", Validators.required],
    building: [""],
    street: ["", ],
    city: ["", Validators.required],
    district: ["", Validators.required],
    state: ["", Validators.required],
    pin_code: ["", Validators.required],
    country: [""],
    email_id: ["", [Validators.email]],
    website: [""]
  });

  get code(){ return this.EstablsihmentForm.get('code'); }
  get establishment(){ return this.EstablsihmentForm.get('establishment'); }
  get building(){ return this.EstablsihmentForm.get('building'); }
  get street(){ return this.EstablsihmentForm.get('street'); }
  get city(){ return this.EstablsihmentForm.get('city'); }
  get district(){ return this.EstablsihmentForm.get('district'); }
  get state(){ return this.EstablsihmentForm.get('state'); }
  get pin_code(){ return this.EstablsihmentForm.get('pin_code'); }
  get country(){ return this.EstablsihmentForm.get('country'); }
  get email_id(){ return this.EstablsihmentForm.get('email_id'); }
  get website(){ return this.EstablsihmentForm.get('website'); }


  editData(editData) {
    this.disable =true;
    this.EstablsihmentForm.patchValue({
      code: editData.code,
      establishment: editData.establishment,
      building: editData.building,
      street: editData.street,
      city: editData.city,
      district: editData.district,
      state: editData.state,
      pin_code: editData.pin_code,
      country: editData.country,
      email_id: editData.email_id,
      website: editData.website
      
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.EstablishmentDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllEstablishmentList();
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
    this.saveData(this.EstablsihmentForm.value);
   
  }
  saveData(Establishment) {
    if (Establishment) {
      this.httpService
        .httpPostService(environment.EstablishmentMasterSave, Establishment)
        .subscribe(response => {
          if (response.status == 200) {
            this.getAllEstablishmentList();
            this.notify.showSuccess(response.message);
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllEstablishmentList(){
    this.EstablishmentData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllEstablishment).subscribe(res => {
      this.EstablishmentData = res.result;
    });
  }
  reset(){
    this.disable =false;
    this.EstablsihmentForm.reset();
  }
}
