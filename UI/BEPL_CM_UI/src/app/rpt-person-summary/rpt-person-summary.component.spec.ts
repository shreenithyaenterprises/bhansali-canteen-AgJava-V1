import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptPersonSummaryComponent } from './rpt-person-summary.component';

describe('RptPersonSummaryComponent', () => {
  let component: RptPersonSummaryComponent;
  let fixture: ComponentFixture<RptPersonSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptPersonSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptPersonSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
