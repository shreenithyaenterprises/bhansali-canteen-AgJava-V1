import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnRegisteredUserComponent } from './un-registered-user.component';

describe('UnRegisteredUserComponent', () => {
  let component: UnRegisteredUserComponent;
  let fixture: ComponentFixture<UnRegisteredUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnRegisteredUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
