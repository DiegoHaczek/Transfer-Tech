import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableTransferenciaComponent } from './table-transferencia.component';

describe('TableTransferenciaComponent', () => {
  let component: TableTransferenciaComponent;
  let fixture: ComponentFixture<TableTransferenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableTransferenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableTransferenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
