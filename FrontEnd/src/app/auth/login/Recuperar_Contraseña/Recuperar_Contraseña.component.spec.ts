/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Recuperar_ContraseñaComponent } from './Recuperar_Contraseña.component';

describe('Recuperar_ContraseñaComponent', () => {
  let component: Recuperar_ContraseñaComponent;
  let fixture: ComponentFixture<Recuperar_ContraseñaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Recuperar_ContraseñaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Recuperar_ContraseñaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
