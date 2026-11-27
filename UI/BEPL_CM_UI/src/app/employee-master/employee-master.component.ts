import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from "@angular/forms";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";
import Swal from 'sweetalert2/dist/sweetalert2.all.js';
import {formatDate} from '@angular/common';
import * as XLSX from 'xlsx';


@Component({
  selector: 'app-employee-master',
  templateUrl: './employee-master.component.html',
  styleUrls: ['./employee-master.component.css'],
})
export class EmployeeMasterComponent implements OnInit {
  siteList =[];
  filteredData =[];
  isEdit: boolean =false;
  establishmentList =[];
  divisionList =[];
  departmentList =[];
  categoryList =[];
  designationList =[];
  gradeList =[];
  contractorList=[];
  currentDateTime : string="";
  dialogDisplay: boolean = false;
  arrayBuffer:any;
  file:File;
  datePickerConfig = {
    drops: 'down',
    format: 'DD/MM/YYYY',
    todayText: 'Oggi',
    style: 'big'
  }
  disable : boolean =false;
  constructor(
    private fb: FormBuilder, private httpService: HttpService, private notify: NotificationService
  
  ) {
     this.currentDateTime = formatDate(new Date(), 'dd/MM/yyyy', 'en');
     console.log('Current Date:', this.currentDateTime);
    } 
  employeeData = [];
  ngOnInit() {
    this.getAllEmployeeList();
    this.getsiteList();
    this.getestablishmentList();
    this.getdivisionList();
    this.getdepartmentList();
    this.getcategoryList();
    this.getdesignationList();
    this.getgradeList();
    this.getContractorList();
  }
   
    EmployeeMasterForm = this.fb.group({
    empcode: ["", Validators.required],
    enrollment_number: ["", Validators.required],
    empname: ["", Validators.required],
    gender: [""],
    dob: [formatDate(new Date(), 'dd/MM/yyyy', 'en')],
    doj: [formatDate(new Date(), 'dd/MM/yyyy', 'en')],
    dol: ["" ],
    mobile: ["", ],
    emailid: ["", ],
    site: ["", Validators.required],
    establishment: ["", Validators.required],
    division: ["", Validators.required],
    department: ["", Validators.required],
    category: ["", Validators.required],
    designation: ["", Validators.required],
    grade: ["", Validators.required],
    contractor: ["", Validators.required],
    left: [""],
    left_date: [new Date().toISOString().split('T')[0]],

  });
  
  get empcode(){ return this.EmployeeMasterForm.get('empcode'); }
  //get title(){ return this.EmployeeMasterForm.get('title'); }
  get empname(){ return this.EmployeeMasterForm.get('empname'); }
  get gender(){ return this.EmployeeMasterForm.get('gender'); }
  get dob(){ return this.EmployeeMasterForm.get('dob'); }
  get doj(){ return this.EmployeeMasterForm.get('doj'); }
  get dol(){ return this.EmployeeMasterForm.get('dol'); }
  get mobile(){ return this.EmployeeMasterForm.get('mobile'); }
  get emailid(){ return this.EmployeeMasterForm.get('emailid'); }
  get site(){ return this.EmployeeMasterForm.get('site'); }
  get establishment(){ return this.EmployeeMasterForm.get('establishment'); }
  get division(){ return this.EmployeeMasterForm.get('division'); }
  get department(){ return this.EmployeeMasterForm.get('department'); }
  get category(){ return this.EmployeeMasterForm.get('category'); }
  get designation(){ return this.EmployeeMasterForm.get('designation'); }
  get grade(){ return this.EmployeeMasterForm.get('grade'); }
  get enrollment_number(){ return this.EmployeeMasterForm.get('enrollment_number'); }
  get contractor(){ return this.EmployeeMasterForm.get('contractor'); }

  genderList: any[] = [
    { code: "M", name: "Male" },
    { code: "F", name: "Female" }
  ];
  titleList: any[] = [
    { code: "Mr", name: "Mr" },
    { code: "Ms", name: "Ms" },
    { code: "Mrs", name: "Mrs" },
  ];
  showDialog(){
    this.dialogDisplay = true;
  }
  editData(editData) {
    this.isEdit=true;
    this.disable =true;
      this.EmployeeMasterForm.patchValue({
      empcode: editData.empcode,
      enrollment_number: editData.enrollment_number,
      empname: editData.empname,
      gender: editData.gender,
      dob: editData.dob,
      doj: editData.doj,
      dol: editData.dol,
      mobile: editData.mobile,
      emailid: editData.emailid,
      site: editData.site,
      establishment: editData.establishment,
      division: editData.division,
      department: editData.department,
      category: editData.category,
      designation: editData.designation,
      grade: editData.grade,
      enrollment_no: editData.enrollment_no,
      contractor: editData.contractor,
      left: editData.left,
      left_date: editData.left_date? editData.left_date: new Date().toISOString().split('T')[0]
    });
  }
  deleteData(Data) {
    this.httpService
    .httpPostService(environment.EmployeeDelete, Data)
    .subscribe(response => {
      if (response.status == 200) {
        this.notify.showSuccess(response.message);
        this.getAllEmployeeList();
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
  Reset(){
    this.isEdit=false;
    this.EmployeeMasterForm.reset();
    this.disable =false;
  }
  Submit() {
    this.saveData(this.EmployeeMasterForm.value);
  }
  saveData(empMas) {
    if (empMas) {
      this.httpService
        .httpPostService(environment.EmployeeMasterSave, empMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            this.getAllEmployeeList();
            this. Reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
  onChangeRB(value){
    this.filteredData=[];
    if (value=='L')
    {
      this.filteredData = this.employeeData.filter((e) => 
      e.left && e.left==1);
    }else
    {
      this.filteredData = this.employeeData.filter((e) => 
      e.left && e.left==0 || e.left == null);
    }
    //this.getAllEmployeeList();
  }
  getAllEmployeeList(){
      this.employeeData=[];
      this.filteredData =[];
      var payload={};
      var url=environment.getAllEmployee;

      if (localStorage.getItem('role')=='1'){
        payload['site']=localStorage.getItem('site')
        url=environment.getAllEmployeeBySite;
      }

      this.httpService.httpPostService(url,payload).subscribe(res => {
          this.employeeData = res.result;
          //this.filteredData=this.employeeData;
          this.filteredData = this.employeeData.filter((e) => 
          e.left && e.left==0 || e.left == null);
      });
  }
  getsiteList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllsite)
      .subscribe(res => {
        this.siteList = res.result; 
      });
  }
  getContractorList() {
    this.httpService
      .httpGetService(environment.getAllcontractor)
      .subscribe(res => {
        this.contractorList = res.result; 
      });
  }
  getestablishmentList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllEstablishment)
      .subscribe(res => {
        this.establishmentList = res.result; 
      });
  }
  getdivisionList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllDivision)
      .subscribe(res => {
        this.divisionList = res.result; 
      });
  }
  getdepartmentList() {
    this.httpService
      .httpGetService(environment.getAllDepartment)
      .subscribe(res => {
        this.departmentList = res.result; 
      });
  }
  getcategoryList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllCategory)
      .subscribe(res => {
        this.categoryList = res.result; 
      });
  }
  getdesignationList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllDesignation)
      .subscribe(res => {
        this.designationList = res.result; 
      });
  }
  getgradeList() {
    this.httpService
      .httpPostServiceWithoutBody(environment.getAllGrade)
      .subscribe(res => {
        this.gradeList = res.result; 
      });
  }
  applyFilter(filterValue: string) {
    debugger;
    this.filteredData=this.employeeData;
    let filterValueLower = filterValue.toLowerCase();
    if(filterValue === '' )
    {
        this.filteredData= this.employeeData
    } else  {
       this.filteredData = this.employeeData.filter((emp) => 
                        emp.empcode && emp.empcode.includes(filterValueLower) || 
                        emp.empname && emp.empname.toLowerCase().includes(filterValueLower) || 
                        emp.mobile && emp.mobile.includes(filterValueLower));
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
           //payload=XLSX.utils.sheet_to_json(worksheet,{raw:false,dateNF:'yyyy-mm-dd'});
           payload=XLSX.utils.sheet_to_json(worksheet,{raw:true});
           console.log(XLSX.utils.sheet_to_json(worksheet,{raw:true}));
           this.SaveBulk(payload);
       }
      
       fileReader.readAsArrayBuffer(this.file);
 }
 SaveBulk(payload){
    this.httpService
    .httpPostService(environment.EmployeeSaveAll, payload)
    .subscribe(response => {
      if (response.status == 200) {
        //debugger;
        this.notify.showSuccess(response.message);
        this.getAllEmployeeList();
        this.Reset();
        this.dialogDisplay = false;
      } else {
        this.notify.showError(response.message);
      }
    });
 }
 exportexcel(): void {
  let element = document.getElementById('employee-list');
  const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.filteredData);//XLSX.utils.table_to_sheet(element);
  const wb: XLSX.WorkBook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(wb, ws, 'Employee Master');
  XLSX.writeFile(wb, 'Employee Master.xlsx');
 }
}
