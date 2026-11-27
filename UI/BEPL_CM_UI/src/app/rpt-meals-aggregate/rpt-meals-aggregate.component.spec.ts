import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptMealsAggregateComponent } from './rpt-meals-aggregate.component';

describe('RptMealsAggregateComponent', () => {
  let component: RptMealsAggregateComponent;
  let fixture: ComponentFixture<RptMealsAggregateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptMealsAggregateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptMealsAggregateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
