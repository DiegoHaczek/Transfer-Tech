/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Dorso_DNIComponent } from './Dorso_DNI.component';

describe('Dorso_DNIComponent', () => {
  let component: Dorso_DNIComponent;
  let fixture: ComponentFixture<Dorso_DNIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Dorso_DNIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Dorso_DNIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
