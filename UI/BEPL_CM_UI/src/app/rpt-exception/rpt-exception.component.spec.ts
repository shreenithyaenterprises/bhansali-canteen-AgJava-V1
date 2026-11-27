import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RptExceptionComponent } from './rpt-exception.component';

describe('RptExceptionComponent', () => {
  let component: RptExceptionComponent;
  let fixture: ComponentFixture<RptExceptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RptExceptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RptExceptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
