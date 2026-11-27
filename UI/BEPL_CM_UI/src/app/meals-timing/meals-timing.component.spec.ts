import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MealsTimingComponent } from './meals-timing.component';

describe('MealsTimingComponent', () => {
  let component: MealsTimingComponent;
  let fixture: ComponentFixture<MealsTimingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MealsTimingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MealsTimingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
