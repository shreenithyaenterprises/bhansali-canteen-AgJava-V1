import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmControllerComponent } from './em-controller.component';

describe('EmControllerComponent', () => {
  let component: EmControllerComponent;
  let fixture: ComponentFixture<EmControllerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmControllerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmControllerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
