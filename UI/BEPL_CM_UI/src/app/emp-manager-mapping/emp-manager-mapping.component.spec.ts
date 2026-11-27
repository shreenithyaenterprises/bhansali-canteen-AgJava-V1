import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpManagerMappingComponent } from './emp-manager-mapping.component';

describe('EmpManagerMappingComponent', () => {
  let component: EmpManagerMappingComponent;
  let fixture: ComponentFixture<EmpManagerMappingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpManagerMappingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpManagerMappingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
