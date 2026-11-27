import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptMealsSummaryComponent } from './rpt-meals-summary.component';

describe('RptMealsSummaryComponent', () => {
  let component: RptMealsSummaryComponent;
  let fixture: ComponentFixture<RptMealsSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptMealsSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptMealsSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
