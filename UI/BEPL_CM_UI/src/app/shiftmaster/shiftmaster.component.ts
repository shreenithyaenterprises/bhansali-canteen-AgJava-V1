import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import * as moment from 'moment'; 
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-shiftmaster',
  templateUrl: './shiftmaster.component.html',
  styleUrls: ['./shiftmaster.component.css']
})
export class ShiftmasterComponent implements OnInit {

  shiftData =[];
  establishmentList =[];
  currentDateTime : string="";
  
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
    this.getAllShiftList();
    //this.getestablishmentList();
  }
  
  ShiftForm = this.fb.group({
    shift_code: ["", Validators.required],
    shift_type: ["day", Validators.required],
    in_time: ["", Validators.required],
    out_time: ["", Validators.required],
    lunch_in: [""],
    lunch_out: [""],
    shift_range_from: ["", Validators.required],
    shift_range_to: ["", Validators.required],
    site_code: [""],
  });
  
  get shift_code(){ return this.ShiftForm.get('shift_code'); }
  get shift_type(){ return this.ShiftForm.get('shift_type'); }
  get in_time(){ return this.ShiftForm.get('in_time'); }
  get out_time(){ return this.ShiftForm.get('out_time'); }
  get lunch_in(){ return this.ShiftForm.get('lunch_in'); }
  get lunch_out(){ return this.ShiftForm.get('lunch_out'); }
  get shift_range_from(){ return this.ShiftForm.get('shift_range_from'); }
  get shift_range_to(){ return this.ShiftForm.get('shift_range_to'); }
  get site_code(){ return this.ShiftForm.get('site_code'); }

  editData(editData) {
      this.ShiftForm.patchValue({
        shift_code: editData.shift_code,
        shift_type: editData.shift_type,
        in_time: editData.in_time,
        out_time: editData.out_time,
        lunch_in: editData.lunch_in,
        lunch_out: editData.lunch_out,
        shift_range_from: editData.shift_range_from,
        shift_range_to: editData.shift_range_to,
        site_code: editData.site_code
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deleteshiftbyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllShiftList();
         this.ShiftForm.reset();
      } else {
        this.notify.showError(response.message);
      }
    });
  }
  Submit() {
    this.saveData(this.ShiftForm.value);
  }
  saveData(shift) {
    if (shift) {
      this.httpService
        .httpPostService(environment.shiftSave, shift)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllShiftList();
            this.ShiftForm.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllShiftList(){
    this.shiftData=[];
    this.httpService.httpGetService(environment.getAllshift).subscribe(res => {
        this.shiftData = res.result;
    });
  }

}
