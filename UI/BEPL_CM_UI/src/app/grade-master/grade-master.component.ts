import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-grade-master',
  templateUrl: './grade-master.component.html',
  styleUrls: ['./grade-master.component.css']
})
export class GradeMasterComponent implements OnInit {
  disable : boolean =false;

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  gradeData = [];
  ngOnInit() {
    this.getAllGradeList();
  }
    GradeMasterForm = this.fb.group({
    grade_code: ["", Validators.required],
    grade_name: ["", Validators.required]

  });
  
  get grade_code(){ return this.GradeMasterForm.get('grade_code'); }
  get grade_name(){ return this.GradeMasterForm.get('grade_name'); }

  editData(editData) {
    this.disable =true;
    this.GradeMasterForm.patchValue({
      grade_code: editData.grade_code,
      grade_name: editData.grade_name
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.GradeDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllGradeList();
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
    this.saveData(this.GradeMasterForm.value);
  }
  saveData(gradeMas) {
    if (gradeMas) {
      this.httpService
        .httpPostService(environment.GradeMasterSave, gradeMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllGradeList();
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllGradeList(){
    this.gradeData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllGrade).subscribe(res => {
        this.gradeData = res.result;
    });
  }
 reset(){
  this.disable =false;
  this.GradeMasterForm.reset();
 }
}
