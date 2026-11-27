import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptContractorComponent } from './rpt-contractor.component';

describe('RptContractorComponent', () => {
  let component: RptContractorComponent;
  let fixture: ComponentFixture<RptContractorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptContractorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptContractorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
