import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-meals-timing',
  templateUrl: './meals-timing.component.html',
  styleUrls: ['./meals-timing.component.css']
})
export class MealsTimingComponent implements OnInit {
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
    this.getAllMealTimingList();
    this.getAllmealsList();
    this.getAllSiteList();
    this.getAllShiftList();
    //this.getcategoryList();
    
  }
  
  MealForm = this.fb.group({
    mealCode: ["", Validators.required],
    mealName: ["", Validators.required],
    time_range_from: ["", Validators.required],
    time_range_to: ["", Validators.required],
    siteCode: ["",Validators.required],
    shiftCode: ["",Validators.required],
    emp_contribution: [""],
    cmpy_contribution: [""],
    cost: [""],
  });
  
  get mealCode(){ return this.MealForm.get('mealCode'); }
  get mealName(){ return this.MealForm.get('mealName'); }
  get time_range_from(){ return this.MealForm.get('time_range_from'); }
  get time_range_to(){ return this.MealForm.get('time_range_to'); }
  get siteCode(){ return this.MealForm.get('siteCode'); }
  get shiftCode(){ return this.MealForm.get('shiftCode'); }
  get emp_contribution(){ return this.MealForm.get('emp_contribution'); }
  get cmpy_contribution(){ return this.MealForm.get('cmpy_contribution'); }
  get cost(){ return this.MealForm.get('cost'); }

  editData(editData) {
      this.disable =true;
      this.MealForm.patchValue({
        mealCode: editData.mealCode,
        mealName: editData.mealName,
        shiftCode: editData.shiftCode,
        time_range_from: editData.time_range_from,
        time_range_to: editData.time_range_to,
        siteCode: editData.siteCode,
        emp_contribution: editData.emp_contribution,
        cmpy_contribution: editData.cmpy_contribution,
        cost: editData.cost,
 
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.deletemealsTimingbyId, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllMealTimingList();
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
        .httpPostService(environment.mealsTimingSave, meal)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllMealTimingList();
            this.MealForm.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  mealChange(event){
    //console.log(event.target.options[event.target.options.selectedIndex].text)
    
    this.MealForm.patchValue({
       mealName: event.target.options[event.target.options.selectedIndex].text
    });
  }
  getAllMealTimingList() {
    this.mealData=[];
    var payload={};
    var url=environment.getAllmealsTimingDetails;
    if (localStorage.getItem('role')=='1') {
      payload['site']=localStorage.getItem('site')
      url=environment.getAllmealsTimingBySite;
    }
    this.httpService.httpPostService(url,payload).subscribe(res => {
        this.mealData = res.result;
        this.mealFLTRData= res.result;
    });
  }
  calculateCost(){
       
        let emp_cont=this.MealForm.get('emp_contribution').value || 0;
        let cmpy_cont=this.MealForm.get('cmpy_contribution').value || 0;
        this.MealForm.patchValue({
          cost: emp_cont+cmpy_cont
        });
  }
  getAllSiteList() {
    this.unitList=[];
    this.httpService.httpPostServiceWithoutBody(environment.getAllsite).subscribe(res => {
        this.unitList = res.result;
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
  getAllShiftList(){
    this.shiftList=[];
    this.httpService.httpGetService(environment.getAllshift).subscribe(res => {
        this.shiftList = res.result;

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
