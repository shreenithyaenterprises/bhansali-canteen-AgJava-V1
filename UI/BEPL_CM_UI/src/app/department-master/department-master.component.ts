import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import * as XLSX from 'xlsx';
import Swal from 'sweetalert2/dist/sweetalert2.all.js';

@Component({
  selector: 'app-department-master',
  templateUrl: './department-master.component.html',
  styleUrls: ['./department-master.component.css']
})
export class DepartmentMasterComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {} 
  deptData = [];
  disable : boolean =false;
  deptFilterData = [];
  dialogDisplay: boolean = false;
  arrayBuffer:any;
  file:File;
  ngOnInit() {
    this.getAllDepartmentList();
  }
  DeptMasterForm = this.fb.group({
    dept_code: ["", Validators.required],
    dept_name: ["", Validators.required]
  });
  showDialog(){
    this.dialogDisplay = true;
  }
  get dept_code(){ return this.DeptMasterForm.get('dept_code'); }
  get dept_name(){ return this.DeptMasterForm.get('dept_name'); }

  editData(editData) {
    this.disable =true;
    this.DeptMasterForm.patchValue({
      dept_code: editData.dept_code,
      dept_name: editData.dept_name
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.DepartmentDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllDepartmentList();
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
    this.saveData(this.DeptMasterForm.value);
  }
  saveData(deptMas) {
    if (deptMas) {
      this.httpService
        .httpPostService(environment.DepartmentMasterSave, deptMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this. getAllDepartmentList();
            this.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  reset(){
    this.disable=false;
    this.DeptMasterForm.reset();
  }
  getAllDepartmentList(){
    this.deptData=[];
    this.httpService.httpGetService(environment.getAllDepartment).subscribe(res => {
        this.deptData = res.result;
        this.deptFilterData = res.result;
    });
  }
  applyFilter(filterValue: string) {
    //debugger;
    //this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.deptFilterData= this.deptData
    } else  {
       this.deptFilterData = this.deptData.filter((dept) => 
                        dept.dept_code && dept.dept_code.toLowerCase().includes(filterValueLower) || 
                        dept.dept_name && dept.dept_name.toLowerCase().includes(filterValueLower)); 

    }
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
  .httpPostService(environment.DepartmentSaveAll, payload)
  .subscribe(response => {
    if (response.status == 200) {
      this.notify.showSuccess(response.message);
      this.getAllDepartmentList();
      this.DeptMasterForm.reset();
      
    } else {
      this.notify.showError(response.message);
    }
  });
  this.dialogDisplay = false;
}
}
