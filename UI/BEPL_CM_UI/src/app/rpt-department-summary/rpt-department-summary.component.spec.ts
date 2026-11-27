import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptDepartmentSummaryComponent } from './rpt-department-summary.component';

describe('RptDepartmentSummaryComponent', () => {
  let component: RptDepartmentSummaryComponent;
  let fixture: ComponentFixture<RptDepartmentSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptDepartmentSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptDepartmentSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
