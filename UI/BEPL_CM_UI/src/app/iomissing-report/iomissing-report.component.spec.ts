import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IOMissingReportComponent } from './iomissing-report.component';

describe('IOMissingReportComponent', () => {
  let component: IOMissingReportComponent;
  let fixture: ComponentFixture<IOMissingReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IOMissingReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IOMissingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
