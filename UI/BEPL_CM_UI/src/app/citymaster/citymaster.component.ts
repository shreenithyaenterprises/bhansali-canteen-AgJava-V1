import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup, Validators, FormControl } from "@angular/forms";
import { Router } from "@angular/router";
import { HttpService } from "../services/http.service";
import { environment } from "../../environments/environment";
import { NotificationService } from "../services/notification.service";

@Component({
  selector: "app-citymaster",
  templateUrl: "./citymaster.component.html",
  styleUrls: ["./citymaster.component.css"]
})
export class CitymasterComponent implements OnInit {
  constructor(
    private fb: FormBuilder,
    private httpService: HttpService,
    private notify: NotificationService
  ) {}

  ngOnInit() {}
  CityMasterForm = this.fb.group({
    city_code: ["", Validators.required],
    city_name: ["", Validators.required],
    state_code: ["", Validators.required],
    state_name: ["", [Validators.required]]
  });
  Submit() {
    this.saveData(this.CityMasterForm.value);
  }
  saveData(CityMas) {
    if (CityMas) {
      this.httpService
        .httpPostService(environment.cityMaster, CityMas)
        .subscribe(response => {
          if (response.status == 200) {
            this.notify.showSuccess(response.message);
            // this.SendSMSForm.reset();
          } else {
            this.notify.showError(response.message);
          }
        });
    }
  }
}
