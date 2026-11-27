import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AppLayoutComponent } from "./app-layout/app-layout.component";
import { CitymasterComponent } from "./citymaster/citymaster.component";
import { EmpManagerMappingComponent } from "./emp-manager-mapping/emp-manager-mapping.component";
import { EmployeeMasterComponent } from "./employee-master/employee-master.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { SiteMasterComponent } from "./site-master/site-master.component";
import { ChnagePasswordComponent } from './chnage-password/chnage-password.component';
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { EmergencycontactComponent } from './emergencycontact/emergencycontact.component';
import { ContractorComponent } from './contractor/contractor.component';
import { ShiftmasterComponent } from './shiftmaster/shiftmaster.component';
import { EstablishmentComponent } from './establishment/establishment.component';
import { DivisionMasterComponent } from './division-master/division-master.component';
import { DepartmentMasterComponent } from './department-master/department-master.component';
import { CategoryMasterComponent } from './category-master/category-master.component';
import { DesignationMasterComponent } from './designation-master/designation-master.component';
import { DeviceComponent } from './device/device.component';
import { GradeMasterComponent } from './grade-master/grade-master.component';
import { EmControllerComponent } from './em-controller/em-controller.component';
import { SummaryReportComponent } from './summary-report/summary-report.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { IOMissingReportComponent } from './iomissing-report/iomissing-report.component';
import { MealsTimingComponent } from './meals-timing/meals-timing.component';
import { SiteDashboardComponent } from "./site-dashboard/site-dashboard.component";
import { RptExceptionComponent } from "./rpt-exception/rpt-exception.component";
import { RptDepartmentSummaryComponent } from "./rpt-department-summary/rpt-department-summary.component";
import { RptPersonSummaryComponent } from "./rpt-person-summary/rpt-person-summary.component";
import { RptMealsSummaryComponent } from "./rpt-meals-summary/rpt-meals-summary.component";
import { RptDepartmentCountComponent } from "./rpt-department-count/rpt-department-count.component";
import { RptDateWiseEmpSummaryComponent } from "./rpt-date-wise-emp-summary/rpt-date-wise-emp-summary.component";
import { AuthGuard } from "./auth.guard";
import { RptMealsAggregateComponent } from "./rpt-meals-aggregate/rpt-meals-aggregate.component";
import { RptContractorComponent } from "./rpt-contractor/rpt-contractor.component";
import { UnRegisteredUserComponent } from "./un-registered-user/un-registered-user.component";
import { MealsRateComponent } from "./meals-rate/meals-rate.component";





const routes: Routes = [
  // App Layout common for all
  { 
    path: '', component: AppLayoutComponent,
    //canActivateChild: [AdminGuard],
    children: [
      { path: "site", component: SiteMasterComponent },
      { path: "Establishment", component: EstablishmentComponent },
      { path: "Division", component: DivisionMasterComponent },
      { path: "Department", component: DepartmentMasterComponent },
      { path: "Category", component: CategoryMasterComponent },
      { path: "Designation", component: DesignationMasterComponent },
      { path: "Grade", component: GradeMasterComponent },
      { path: "cityMaster", component: CitymasterComponent },
      { path: "Employee", component: EmployeeMasterComponent },
      { path: "empMapping", component:  EmpManagerMappingComponent},
      { path: "home", component: HomeComponent },
      { path: "userProfile", component: UserProfileComponent },
      { path: "emergencyContact", component: EmergencycontactComponent },
      { path: "Contractor", component: ContractorComponent },
      { path: "Device", component: DeviceComponent },
      { path: "Shift", component: ShiftmasterComponent },
      { path: "EMController", component: EmControllerComponent },
      { path: "Sitedsb", component: SiteDashboardComponent },
      { path: "IOMissingReport", component: IOMissingReportComponent },
      { path: "MealsTiming", component: MealsTimingComponent },
      { path: "SummaryReport", component: SummaryReportComponent },
      { path: "ExceptionReport", component: RptExceptionComponent },
      { path: "DeptSummaryReport", component: RptDepartmentSummaryComponent },
      { path: "DeptwiseCountReport", component: RptDepartmentCountComponent },
      { path: "PersonSummaryReport", component: RptPersonSummaryComponent },
      { path: "MealsSummaryReport", component: RptMealsSummaryComponent },
      { path: "DateandEmpwiseSummary", component: RptDateWiseEmpSummaryComponent },
      { path: "AggregateMealsReport", component: RptMealsAggregateComponent },
      { path: "ContractorReport", component: RptContractorComponent },
      { path: "unRegisteredUser", component: UnRegisteredUserComponent },
      { path: "mealsRate", component:  MealsRateComponent},
      { path:'',redirectTo:'/login',pathMatch:'full'},
     // { path: 'ChangePassword', component:  ChnagePasswordComponent},
     // { path: '**', redirectTo: '/login' },
      
    ]
  },
  // Blank Layout
  { path: 'ChangePassword', component:  ChnagePasswordComponent },
  { path: 'Dashboard', component: DashboardComponent },
  { path:'',redirectTo:'/login',pathMatch:'full'},
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '/login' },
 // { path: 'approval/:VisitorId', component: VisitorApprovalComponent },
 // { path: '', component: LoginComponent },
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
