/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Verificar_Telefono_P2Component } from './Verificar_Telefono_P2.component';

describe('Verificar_Telefono_P2Component', () => {
  let component: Verificar_Telefono_P2Component;
  let fixture: ComponentFixture<Verificar_Telefono_P2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Verificar_Telefono_P2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Verificar_Telefono_P2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
