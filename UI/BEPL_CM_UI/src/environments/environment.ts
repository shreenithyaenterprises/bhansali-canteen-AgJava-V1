// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
//10-10.70.240:8080,  
export const environment = {
  production: false,
  cityMaster: "http://localhost:8081/KEC-CM-API/city/save",
  // Siter Master
  siteMasterSave: "http://localhost:8081/KEC-CM-API/site/save",
  getAllsite: "http://localhost:8081/KEC-CM-API/site/getAllSite",
  siteMasterDelete: "http://localhost:8081/KEC-CM-API/site/deleteSiteById",
  // Establishment
  EstablishmentMasterSave: "http://localhost:8081/KEC-CM-API/Establishment/save",
  getAllEstablishment: "http://localhost:8081/KEC-CM-API/Establishment/getAllEstablishment",
  EstablishmentDelete: "http://localhost:8081/KEC-CM-API/Establishment/deleteEstablishmentById",
    // Division
    DivisionMasterSave: "http://localhost:8081/KEC-CM-API/division/save",
    getAllDivision: "http://localhost:8081/KEC-CM-API/division/getAllDivision",
    DivisionDelete: "http://localhost:8081/KEC-CM-API/division/deleteDivisionById",
    // Department
    DepartmentMasterSave: "http://localhost:8081/KEC-CM-API/department/save",
    DepartmentSaveAll: "http://localhost:8081/KEC-CM-API/department/saveAll",
    getAllDepartment: "http://localhost:8081/KEC-CM-API/department/getAllDepartment",
    DepartmentDelete: "http://localhost:8081/KEC-CM-API/department/deleteDepartmentById",
    // CategoryMaster
    CategoryMasterSave: "http://localhost:8081/KEC-CM-API/category/save",
    getAllCategory: "http://localhost:8081/KEC-CM-API/category/getAllCategory",
    CategoryDelete: "http://localhost:8081/KEC-CM-API/category/deleteCategoryById",
    // CategoryMaster
    DesignationMasterSave: "http://localhost:8081/KEC-CM-API/designation/save",
    getAllDesignation: "http://localhost:8081/KEC-CM-API/designation/getAllDesignation",
    DesignationDelete: "http://localhost:8081/KEC-CM-API/designation/deleteDesignationById",
    // GradeMaster
    GradeMasterSave: "http://localhost:8081/KEC-CM-API/grade/save",
    getAllGrade: "http://localhost:8081/KEC-CM-API/grade/getAllGrade",
    GradeDelete: "http://localhost:8081/KEC-CM-API/grade/deleteGradeById",
    // BelongingMaster
    BelongingMasterSave: "http://localhost:8081/KEC-CM-API/belonging/save",
    getAllBelonging: "http://localhost:8081/KEC-CM-API/belonging/getAllBelonging",
    BelongingDelete: "http://localhost:8081/KEC-CM-API/belonging/deleteBelongingById",
    // EmployeeMaster
    EmployeeMasterSave: "http://localhost:8081/KEC-CM-API/employee/save",
    EmployeeSaveAll: "http://localhost:8081/KEC-CM-API/employee/saveAll",
    getAllEmployee: "http://localhost:8081/KEC-CM-API/employee/getAllEmployee",
    getAllEmployeeBySite: "http://localhost:8081/KEC-CM-API/employee/getAllEmployeeBySite",
    EmployeeDelete: "http://localhost:8081/KEC-CM-API/employee/deleteEmployeeById",
    // Company Master
    CompanyMasterSave: "http://localhost:8081/KEC-CM-API/company/save",
    getCompanyById: "http://localhost:8081/KEC-CM-API/company/getCompanyById",  
    CompanyDelete: "http://localhost:8081/KEC-CM-API/company/deleteCompanyById",
    // OT Module
    getDepartmentList: "http://localhost:8081/KEC-CM-API/department/getDepartmentList",
    getEmployeeList: "http://localhost:8081/KEC-CM-API/employee/getEmployeeList",
    getAllEmployeeList: "http://localhost:8081/KEC-CM-API/employee/getAllEmployeeList",
    otBulkRequest: "http://localhost:8081/KEC-CM-API/OTRequest/save",
    otReportbyDate: "http://localhost:8081/KEC-CM-API/OTRequest/getOTDetailsbyDate",
    AttApproveorRejectbyMGR: "http://localhost:8081/KEC-CM-API/Attendance/ApproveorRejectbyMGR",
    AttApproveorRejectbyAdmin: "http://localhost:8081/KEC-CM-API/Attendance/ApproveorRejectbyAdmin",
    otApprovalbyDH: "http://localhost:8081/KEC-CM-API/OTRequest/getOTforDHApproval",//http://localhost:8081/KEC-CM-API/OTRequest/getOTDetailsforDHApproval",
    otRejectionbyFH: "http://localhost:8081/KEC-CM-API/OTRequest/getOTDetailsforFHRejection",
    otFHReject: "http://localhost:8081/KEC-CM-API/OTRequest/RejectOT", 
    EmpManagerMappingDtl: "http://localhost:8081/KEC-CM-API/employee/getEmpMappingDtl",
    EmpManagerMappingUpdate: "http://localhost:8081/KEC-CM-API/employee/updateEmpMapping",
    otApprovedList: "http://localhost:8081/KEC-CM-API/OTRequest/getApprovedOTDetails",
    otAdminApprovedList: "http://localhost:8081/KEC-CM-API/OTRequest/getOTforAdminApproval",
    // User Management
      userLogin: "http://localhost:8081/KEC-CM-API/user/validateUser/",
      forgotPassword: "http://localhost:8081/KEC-CM-API/user/forgotPassword",
      resetPassword: "http://localhost:8081/KEC-CM-API/user/forgotPassword",
      userProfileSave:"http://localhost:8081/KEC-CM-API/user/save/",
      getAllUsers:"http://localhost:8081/KEC-CM-API/user/getAlluser/",
      deleteUser:"http://localhost:8081/KEC-CM-API/user/deleteuserById/",
     //Emergency Contact Details
    emContactSave: "http://localhost:8081/KEC-CM-API/EMContact/save",
    //getAllDetails: "http://localhost:8081/KEC-CM-API/EMContact/getAllEMContact",
    getAllDetails: "http://localhost:8081/KEC-CM-API/EMContact/getAllEMContact",
    getemConactbyId: "http://localhost:8081/KEC-CM-API/EMContact/getEMContactById",
    deleteEmConactbyId: "http://localhost:8081/KEC-CM-API/EMContact/deleteEMContactById",
    //Emergency Controller Details
    emControllerSave: "http://localhost:8081/KEC-CM-API/emergency/save",
    getAllemControllerDetails: "http://localhost:8081/KEC-CM-API/emergency/getAllemergency",
    getemControllerbyId: "http://localhost:8081/KEC-CM-API/emergency/getemergencyById",
    deleteEmControllerbyId: "http://localhost:8081/KEC-CM-API/emergency/deleteemergencyById",
    //Meals Timing Controller Details
    mealsTimingSave: "http://localhost:8081/KEC-CM-API/mealsTiming/save",
    getAllmealsTimingDetails: "http://localhost:8081/KEC-CM-API/mealsTiming/getAllmealsTiming",
    getmealsTimingbyId: "http://localhost:8081/KEC-CM-API/mealsTiming/getmealsTimingById",
    deletemealsTimingbyId: "http://localhost:8081/KEC-CM-API/mealsTiming/deletemealsTimingById",
    getAllmealsTimingBySite:"http://localhost:8081/KEC-CM-API/mealsTiming/getAllmealsTimingBySite",
    //Meals Rate 
    mealsRateSave: "http://localhost:8081/KEC-CM-API/MealsRate/save",
    getAllmealsRateDetails: "http://localhost:8081/KEC-CM-API/MealsRate/getAllMealRate",
    getmealsRatebyId: "http://localhost:8081/KEC-CM-API/MealsRate/getMealRateById",
    deletemealsRatebyId: "http://localhost:8081/KEC-CM-API/MealsRate/deleteMealRateById",
    //Contractor Master
    contractorSave: "http://localhost:8081/KEC-CM-API/contractor/save",
    contractorSaveAll: "http://localhost:8081/KEC-CM-API/contractor/saveAll",
    getAllcontractor: "http://localhost:8081/KEC-CM-API/contractor/getAllContractor",
    getcontractorbyId: "http://localhost:8081/KEC-CM-API/contractor/getContractorbyId",
    deleteContractorbyId: "http://localhost:8081/KEC-CM-API/contractor/deleteContractorbyId",
    //Meals Master
    mealsSave: "http://localhost:8081/KEC-CM-API/meals/save",
    getAllmeals: "http://localhost:8081/KEC-CM-API/meals/getAllMeals",
    //getshiftbyId: "http://localhost:8081/KEC-CM-API/shift/getShiftbyId",
    //deleteshiftbyId: "http://localhost:8081/KEC-CM-API/shift/deleteShiftbyId",
    //Shift Master
    shiftSave: "http://localhost:8081/KEC-CM-API/shift/save",
    getAllshift: "http://localhost:8081/KEC-CM-API/shift/getAllshift",
    getshiftbyId: "http://localhost:8081/KEC-CM-API/shift/getShiftbyId",
    deleteshiftbyId: "http://localhost:8081/KEC-CM-API/shift/deleteShiftbyId",
    //Device Master
    deviceSave: "http://localhost:8081/KEC-CM-API/device/save",
    getAlldevice: "http://localhost:8081/KEC-CM-API/device/getAllDevice",
    getAlldevicebySite: "http://localhost:8081/KEC-CM-API/device/getAllDeviceBySite",
    getdevicebyId: "http://localhost:8081/KEC-CM-API/device/getDevicebyId",
    deletedevicebyId: "http://localhost:8081/KEC-CM-API/device/deleteDevicebyId",
    // DashBoard Data
    getMealCountAllSite: "http://localhost:8081/KEC-CM-API/dsb/getAllSiteCountByItem",
    getMealsSummaryDaily: "http://localhost:8081/KEC-CM-API/dsb/getMealsSummaryDaily",
    getMealsSummaryMonthly: "http://localhost:8081/KEC-CM-API/dsb/getMealsSummaryMonthly",
    getMealsDetail: "http://localhost:8081/KEC-CM-API/dsb/getMealsDetail",
    getMealsDetailMonthly: "http://localhost:8081/KEC-CM-API/dsb/getMealsDetailMonthly",
    getIOCountDeptWise: "http://localhost:8081/KEC-CM-API/ahc/getIOCountDeptWise",
    getIOCountContWise: "http://localhost:8081/KEC-CM-API/ahc/getIOCountContWise",
    getIOCountdetail: "http://localhost:8081/KEC-CM-API/Report/getIODetail",
    getAttDetails: "http://localhost:8081/KEC-CM-API/hc/getAttendancebyEmployee",
    getAttRegularizationRPT: "http://localhost:8081/KEC-CM-API/hc/getAttRegularizationRpt",
    //Report
    getSummaryReportbyDate: "http://localhost:8081/KEC-CM-API/Report/getSummaryReportbyDate",
    getExceptionReportbyDate: "http://localhost:8081/KEC-CM-API/Report/getExceptionReportbyDate",
    getDepartmentSummarybyDate: "http://localhost:8081/KEC-CM-API/Report/getDepartmentSummarybyDate",
    getPersonSummarybyDate: "http://localhost:8081/KEC-CM-API/Report/getPersonSummarybyDate",
    getMealSummarybyDate: "http://localhost:8081/KEC-CM-API/Report/getMealSummarybyDate",
    getDeptwiseCountbyDate: "http://localhost:8081/KEC-CM-API/Report/getDeptwiseCountbyDate",
    getDatewiseEmpMeals: "http://localhost:8081/KEC-CM-API/Report/getDatewiseEmpMeals",
    getDatesbetweenfromAndTo: "http://localhost:8081/KEC-CM-API/Report/getDatesBetweenfromAndTo",
    getIOMissingReport: "http://localhost:8081/KEC-CM-API/Report/getIOMissing",
    getSummaryData: "http://localhost:8081/KEC-CM-API/Report/getSummaryData",
    getinsideData: "http://localhost:8081/KEC-CM-API/Report/getInsideData",
    getMealAggregate: "http://localhost:8081/KEC-CM-API/Report/getMealAggregate",
    getUnregisteredUser: "http://localhost:8081/KEC-CM-API/Report/getUnregisteredUser",
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
