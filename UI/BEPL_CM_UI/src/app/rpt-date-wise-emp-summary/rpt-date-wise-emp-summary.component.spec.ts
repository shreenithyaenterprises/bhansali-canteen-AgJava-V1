import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptDateWiseEmpSummaryComponent } from './rpt-date-wise-emp-summary.component';

describe('RptDateWiseEmpSummaryComponent', () => {
  let component: RptDateWiseEmpSummaryComponent;
  let fixture: ComponentFixture<RptDateWiseEmpSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptDateWiseEmpSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptDateWiseEmpSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
