import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-meals-rate',
  templateUrl: './meals-rate.component.html',
  styleUrls: ['./meals-rate.component.css']
})
export class MealsRateComponent implements OnInit {

  mealData =[];
  mealFLTRData =[];
  mealList =[];
  categoryList=[];
  currentDateTime : string="";
  unitList=[];
  shiftList=[];

  datePickerConfig = {
    drops: 'down',
    format: 'DD/MM/YYYY',
    todayText: 'Oggi',
    style: 'big'
  }
  disable : boolean =false;
  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  
  ) {
     this.currentDateTime = formatDate(new Date(), 'dd/MM/yyyy', 'en');
     console.log('Current Date:', this.currentDateTime);
  } 
  ngOnInit() {
    this.getAllMealRateList();
    this.getAllmealsList();
    this.getcategoryList();
  }
  
  MealForm = this.fb.group({
    sr_no:[0],
    meal_code: ["", Validators.required],
    cat_code:[""],
    rate: [""],
  });
  
  get mealCode(){ return this.MealForm.get('meal_code'); }
  get category(){ return this.MealForm.get('cat_code'); }
  get rate(){ return this.MealForm.get('rate'); }

  editData(editData) {
      this.disable =true;
      this.MealForm.patchValue({
        sr_no: editData.sr_no,
        meal_code: editData.meal_code,
        cat_code: editData.cat_code,
        rate: editData.rate,
 
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deletemealsRatebyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllMealRateList();
         this.MealForm.reset();
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
    this.saveData(this.MealForm.value);
  }
  Reset(){
    this.disable =false;
    this.MealForm.reset();
  }
  saveData(meal) {
    if (meal) {
      this.httpService
        .httpPostService(environment.mealsRateSave, meal)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllMealRateList();
            this.Reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  getAllMealRateList() {
    this.mealData=[];
    var payload={};
    this.httpService.httpGetService(environment.getAllmealsRateDetails).subscribe(res => {
        this.mealData = res.result;
        this.mealFLTRData= res.result;
    });
  }
  getcategoryList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllCategory)
      .subscribe(res => {
        this.categoryList = res.result; 
      });
  }
  getAllmealsList() {
    this.mealList=[];
    this.httpService.httpGetService(environment.getAllmeals).subscribe(res => {
        this.mealList = res.result;
    });
  }
  applyFilter(filterValue: string) {
    //debugger;
    //this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.mealFLTRData= this.mealData
    } else  {
       this.mealFLTRData = this.mealData.filter((x) => 
                        x.mealName && x.mealName.toLowerCase().includes(filterValueLower) || 
                        x.mealCode && x.mealCode.toLowerCase().includes(filterValueLower) ||
                        x.shiftCode && x.shiftCode.toLowerCase().includes(filterValueLower) ||
                        x.siteCode && x.siteCode.toLowerCase().includes(filterValueLower)
                        ); 

    }
 }

}
