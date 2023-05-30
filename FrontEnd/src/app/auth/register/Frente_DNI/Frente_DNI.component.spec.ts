/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Frente_DNIComponent } from './Frente_DNI.component';

describe('Frente_DNIComponent', () => {
  let component: Frente_DNIComponent;
  let fixture: ComponentFixture<Frente_DNIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Frente_DNIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Frente_DNIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
