import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptDepartmentCountComponent } from './rpt-department-count.component';

describe('RptDepartmentCountComponent', () => {
  let component: RptDepartmentCountComponent;
  let fixture: ComponentFixture<RptDepartmentCountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptDepartmentCountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptDepartmentCountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
