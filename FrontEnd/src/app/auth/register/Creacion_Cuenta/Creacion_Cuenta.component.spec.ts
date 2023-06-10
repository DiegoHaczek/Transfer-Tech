/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Creacion_CuentaComponent } from './Creacion_Cuenta.component';

describe('Creacion_CuentaComponent', () => {
  let component: Creacion_CuentaComponent;
  let fixture: ComponentFixture<Creacion_CuentaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Creacion_CuentaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Creacion_CuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
