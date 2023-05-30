import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmacionTransferenciasComponent } from './confirmacion-transferencias.component';

describe('ConfirmacionTransferenciasComponent', () => {
  let component: ConfirmacionTransferenciasComponent;
  let fixture: ComponentFixture<ConfirmacionTransferenciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmacionTransferenciasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmacionTransferenciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
