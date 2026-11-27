import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';
import {formatDate} from '@angular/common';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-contractor',
  templateUrl: './contractor.component.html',
  styleUrls: ['./contractor.component.css']
})
export class ContractorComponent implements OnInit {

  contractorData =[];
  contractorFLTRData =[];
  establishmentList =[];
  currentDateTime : string="";
  dialogDisplay: boolean = false;
  arrayBuffer:any;
  file:File;
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
     //this.currentDateTime =this.datepipe.transform((new Date), 'dd/MM/yyyy');
     //this.currentDateTime = moment(this.currentDateTime).format('DD/MM/YYYY');
     
     this.currentDateTime = formatDate(new Date(), 'dd/MM/yyyy', 'en');
     console.log('Current Date:', this.currentDateTime);
  } 

  ngOnInit() {
    this.getAllContractorList();
    //this.getestablishmentList();
  }
  
  ContractorForm = this.fb.group({
    cont_code: ["", Validators.required],
    cont_name: ["", Validators.required],
    incharge: ["", Validators.required],
    mobile: ["", Validators.required],
    email_id: ["", Validators.email],
    telephone: [""],
    country: [""],
    state: [""],
    city: [""],
    pin_code: ["", Validators.required],
    add1: [""],
    add2: [""]
  });
  
  get cont_code(){ return this.ContractorForm.get('cont_code'); }
  get cont_name(){ return this.ContractorForm.get('cont_name'); }
  get incharge(){ return this.ContractorForm.get('incharge'); }
  get mobile(){ return this.ContractorForm.get('mobile'); }
  get email_id(){ return this.ContractorForm.get('email_id'); }
  get telephone(){ return this.ContractorForm.get('telephone'); }
  get country(){ return this.ContractorForm.get('country'); }
  get state(){ return this.ContractorForm.get('state'); }
  get city(){ return this.ContractorForm.get('city'); }
  get pin_code(){ return this.ContractorForm.get('pin_code'); }
  get add1(){ return this.ContractorForm.get('add1'); }
  get add2(){ return this.ContractorForm.get('add2'); }

  editData(editData) {
    this.disable =true;
      this.ContractorForm.patchValue({
        cont_code: editData.cont_code,
        cont_name: editData.cont_name,
        incharge: editData.incharge,
        mobile: editData.mobile,
        email_id: editData.email_id,
        telephone: editData.telephone,
        country: editData.country,
        state: editData.state,
        city: editData.city,
        pin_code: editData.pin_code,
        add1: editData.add1,
        add2: editData.add2,
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deleteContractorbyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllContractorList();
         this.Reset();
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
    this.saveData(this.ContractorForm.value);
  }
  Reset(){
    this.ContractorForm.reset();
    this.disable =false;
  }
  applyFilter(filterValue: string) {
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.contractorFLTRData= this.contractorData
    } else  {
       this.contractorFLTRData = this.contractorData.filter((cont) => 
                        cont.cont_code && cont.cont_code.toLowerCase().includes(filterValueLower) || 
                        cont.cont_name && cont.cont_name.toLowerCase().includes(filterValueLower)); 
                       // emp.mobile && emp.mobile.includes(filterValueLower));
    }
 }
  saveData(cont) {
    if (cont) {
      this.httpService
        .httpPostService(environment.contractorSave, cont)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllContractorList();
            this.Reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  showDialog(){
    this.dialogDisplay = true;
  }
  getAllContractorList(){
    this.contractorData=[];
    this.httpService.httpGetService(environment.getAllcontractor).subscribe(res => {
        this.contractorData = res.result;
        this.contractorFLTRData = res.result;
    });
  }

  getestablishmentList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllEstablishment)
      .subscribe(res => {
        this.establishmentList = res.result; 
      });
  }
  incomingfile(event) {
    this.file= event.target.files[0]; 
   }
  
  Upload() {
      let payload=[];
       let fileReader = new FileReader();
         fileReader.onload = (e) => {
             this.arrayBuffer = fileReader.result;
             var data = new Uint8Array(this.arrayBuffer);
             var arr = new Array();
             for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
             var bstr = arr.join("");
             var workbook = XLSX.read(bstr, {type:"binary"});
             var first_sheet_name = workbook.SheetNames[0];
             var worksheet = workbook.Sheets[first_sheet_name];
             payload=XLSX.utils.sheet_to_json(worksheet,{raw:true});
             console.log(XLSX.utils.sheet_to_json(worksheet,{raw:true}));
             this.SaveBulk(payload);
         }
        
         fileReader.readAsArrayBuffer(this.file);
   }
   SaveBulk(payload){
    this.httpService
    .httpPostService(environment.contractorSaveAll, payload)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllContractorList();
        this.Reset();
        
      } else {
        this.notify.showError(response.message);
      }
    });
    this.dialogDisplay = false;
  }
 
}
