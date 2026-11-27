import { BrowserModule } from "@angular/platform-browser";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { DatePipe } from '@angular/common';
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { CitymasterComponent } from "./citymaster/citymaster.component";
import { ToastrModule } from "ngx-toastr";
import { SiteMasterComponent } from './site-master/site-master.component';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from "ngx-ui-loader";
import { EmployeeMasterComponent } from './employee-master/employee-master.component';
import { LoginComponent } from './login/login.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { HomeComponent } from './home/home.component';
import { GoogleChartsModule } from 'angular-google-charts';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {DropdownModule} from 'primeng/dropdown';
import {CalendarModule} from 'primeng/calendar';
import {FileUploadModule} from 'primeng/fileUpload';
import {ToolbarModule} from 'primeng/Toolbar';
import {RatingModule} from 'primeng/Rating';
import {RadioButtonModule} from 'primeng/RadioButton';
import {ConfirmDialogModule} from 'primeng/confirmDialog';
import {FieldsetModule} from 'primeng/fieldset';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {TreeTableModule} from 'primeng/treetable';
import {PanelMenuModule} from 'primeng/panelmenu';
import { EmpManagerMappingComponent } from './emp-manager-mapping/emp-manager-mapping.component';
import { ChnagePasswordComponent } from './chnage-password/chnage-password.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { EmergencycontactComponent } from './emergencycontact/emergencycontact.component';
import { ContractorComponent } from './contractor/contractor.component';
import { ShiftmasterComponent } from './shiftmaster/shiftmaster.component';
import { EstablishmentComponent } from './establishment/establishment.component';
import { DivisionMasterComponent } from './division-master/division-master.component';
import { DepartmentMasterComponent } from './department-master/department-master.component';
import { CategoryMasterComponent } from './category-master/category-master.component';
import { DesignationMasterComponent } from './designation-master/designation-master.component';
import { GradeMasterComponent } from './grade-master/grade-master.component';
import { DeviceComponent } from './device/device.component';
import { EmControllerComponent } from './em-controller/em-controller.component';
import { SummaryReportComponent } from './summary-report/summary-report.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { IOMissingReportComponent } from './iomissing-report/iomissing-report.component';
import { MealsTimingComponent } from './meals-timing/meals-timing.component';
import { SiteDashboardComponent } from './site-dashboard/site-dashboard.component';
import { RptExceptionComponent } from './rpt-exception/rpt-exception.component';
import { RptDepartmentSummaryComponent } from './rpt-department-summary/rpt-department-summary.component';
import { RptPersonSummaryComponent } from './rpt-person-summary/rpt-person-summary.component';
import { RptMealsSummaryComponent } from './rpt-meals-summary/rpt-meals-summary.component';
import { RptDepartmentCountComponent } from './rpt-department-count/rpt-department-count.component';
import { RptDateWiseEmpSummaryComponent } from './rpt-date-wise-emp-summary/rpt-date-wise-emp-summary.component';
import { AuthGuard } from "./auth.guard";
import { httpInterceptor } from "./services/httpInterceptor.service";
import { RptMealsAggregateComponent } from './rpt-meals-aggregate/rpt-meals-aggregate.component';
import { RptContractorComponent } from './rpt-contractor/rpt-contractor.component';
import { UnRegisteredUserComponent } from './un-registered-user/un-registered-user.component';
import { MealsRateComponent } from './meals-rate/meals-rate.component';

@NgModule({
  declarations: [AppComponent, CitymasterComponent, SiteMasterComponent,  EmployeeMasterComponent, LoginComponent, AppLayoutComponent, HomeComponent,  EmpManagerMappingComponent, ChnagePasswordComponent, UserProfileComponent, EmergencycontactComponent, ContractorComponent, ShiftmasterComponent, EstablishmentComponent, DivisionMasterComponent, DepartmentMasterComponent, CategoryMasterComponent, DesignationMasterComponent, GradeMasterComponent, DeviceComponent, EmControllerComponent, SummaryReportComponent, DashboardComponent, IOMissingReportComponent, MealsTimingComponent, SiteDashboardComponent, RptExceptionComponent, RptDepartmentSummaryComponent, RptPersonSummaryComponent, RptMealsSummaryComponent, RptDepartmentCountComponent, RptDateWiseEmpSummaryComponent, RptMealsAggregateComponent, RptContractorComponent, UnRegisteredUserComponent, MealsRateComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgxUiLoaderModule,
    NgxUiLoaderHttpModule.forRoot({ delay:100, minTime:0, showForeground: true, exclude: ["http://10.65.39.43:443/CCMAPI/dsb/"] }),
    GoogleChartsModule,
    TableModule,
    ToastModule,
    DialogModule,
    ButtonModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    FileUploadModule,
    ToolbarModule,
    RatingModule,
    RadioButtonModule,
    ConfirmDialogModule,
    FieldsetModule,
    InputTextareaModule,
    TreeTableModule,
    PanelMenuModule,
   ],
  providers: [
    DatePipe,
   // AuthGuard,
   { provide: HTTP_INTERCEPTORS, useClass: httpInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})

export class AppModule {}
