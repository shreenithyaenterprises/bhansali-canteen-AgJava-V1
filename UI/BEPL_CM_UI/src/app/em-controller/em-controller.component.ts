import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";

@Component({
  selector: 'app-em-controller',
  templateUrl: './em-controller.component.html',
  styleUrls: ['./em-controller.component.css']
})
export class EmControllerComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  emData = [];
  lstShift =[];

  ngOnInit() {
    this. getAllEMControllerList();
    this.getShiftList();
  }
  emControllerForm = this.fb.group({
    em_controller: ["", Validators.required],
    em_mobile_no: ["", Validators.required],
    assembly_point1: ["", Validators.required],
    assembly_point1_mobile: ["", Validators.required],
    assembly_point2: ["", Validators.required],
    assembly_point2_mobile: ["", Validators.required],
    assembly_point3: ["", Validators.required],
    assembly_point3_mobile: ["", Validators.required],
    fire_fighter: ["", Validators.required],
    fire_fighter_mobile: ["", Validators.required],
    first_aider: ["", Validators.required],
    first_aider_mobile: ["", Validators.required],
    shift: ["-1", Validators.required]

  });
  get em_controller(){ return this.emControllerForm.get('em_controller'); }
  get em_mobile_no(){ return this.emControllerForm.get('em_mobile_no'); }
  get assembly_point1(){ return this.emControllerForm.get('assembly_point1'); }
  get assembly_point1_mobile(){ return this.emControllerForm.get('assembly_point1_mobile'); }
  get assembly_point2(){ return this.emControllerForm.get('assembly_point2'); }
  get assembly_point2_mobile(){ return this.emControllerForm.get('assembly_point2_mobile'); }
  get assembly_point3(){ return this.emControllerForm.get('assembly_point3'); }
  get assembly_point3_mobile(){ return this.emControllerForm.get('assembly_point3_mobile'); }
  get fire_fighter(){ return this.emControllerForm.get('fire_fighter'); }
  get fire_fighter_mobile(){ return this.emControllerForm.get('fire_fighter_mobile'); }
  get first_aider(){ return this.emControllerForm.get('first_aider'); }
  get first_aider_mobile(){ return this.emControllerForm.get('first_aider_mobile'); }
  get shift(){ return this.emControllerForm.get('shift'); }


  editData(editData) {
    this.emControllerForm.patchValue({
      em_controller: editData.em_controller,
      em_mobile_no: editData.em_mobile_no,
      assembly_point1: editData.assembly_point1,
      assembly_point1_mobile: editData.assembly_point1_mobile,
      assembly_point2: editData.assembly_point2,
      assembly_point2_mobile: editData.assembly_point2_mobile,
      assembly_point3: editData.assembly_point3,
      assembly_point3_mobile: editData.assembly_point3_mobile,
      fire_fighter: editData.fire_fighter,
      fire_fighter_mobile: editData.fire_fighter_mobile,
      first_aider: editData.first_aider,
      first_aider_mobile: editData.first_aider_mobile,
      shift: editData.shift,
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deleteEmControllerbyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllEMControllerList();
        // this.SendSMSForm.reset();
      } else {
        this.notify.showError(response.message);
      }
    });
 }
  Submit() {
    this.saveData(this.emControllerForm.value);
  }
  Reset() {
    this.emControllerForm.reset();
    this.emControllerForm = this.fb.group({
      shift: "-1"
    });
  }
  saveData(emData) {
    if (emData) {
      this.httpService
        .httpPostService(environment.emControllerSave, emData)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.emControllerForm.reset();
            this.getAllEMControllerList();
            // this.SendSMSForm.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllEMControllerList(){
    this.emData=[];
    this.httpService.httpGetService(environment.getAllemControllerDetails).subscribe(res => {
        this.emData = res.result;
    });
  }
  getShiftList(){
    this.lstShift=[
      {label: 'A', value: 'AA'},
      {label: 'B', value: 'BB'},
      {label: 'C', value: 'CC'},
      {label: 'G', value: 'GN'},
    ]
  }

}
