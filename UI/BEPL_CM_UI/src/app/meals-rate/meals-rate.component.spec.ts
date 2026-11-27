import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MealsRateComponent } from './meals-rate.component';

describe('MealsRateComponent', () => {
  let component: MealsRateComponent;
  let fixture: ComponentFixture<MealsRateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MealsRateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MealsRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
