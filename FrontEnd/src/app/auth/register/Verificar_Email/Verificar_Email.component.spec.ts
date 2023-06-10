/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Verificar_EmailComponent } from './Verificar_Email.component';

describe('Verificar_EmailComponent', () => {
  let component: Verificar_EmailComponent;
  let fixture: ComponentFixture<Verificar_EmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Verificar_EmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Verificar_EmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
