import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-category-master',
  templateUrl: './category-master.component.html',
  styleUrls: ['./category-master.component.css']
})
export class CategoryMasterComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  categoryData = [];
  disable : boolean =false;
  ngOnInit() {
    this.getAllCategoryList();
  }
  CategoryMasterForm = this.fb.group({
    category_code: ["", Validators.required],
    category_name: ["", Validators.required]

  });
  
  get category_code(){ return this.CategoryMasterForm.get('category_code'); }
  get category_name(){ return this.CategoryMasterForm.get('category_name'); }

  editData(editData) {
    this.disable =true;
    this.CategoryMasterForm.patchValue({
      category_code: editData.category_code,
      category_name: editData.category_name
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.CategoryDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllCategoryList();
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
    this.saveData(this.CategoryMasterForm.value);
  }
  saveData(catMas) {
    if (catMas) {
      this.httpService
        .httpPostService(environment.CategoryMasterSave, catMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllCategoryList();
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllCategoryList(){
    this.categoryData=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllCategory).subscribe(res => {
        this.categoryData = res.result;
    });
  }
  reset(){
    this.disable =false;
    this.CategoryMasterForm.reset();
  }
}
