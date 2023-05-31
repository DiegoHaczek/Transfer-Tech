/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Selfie_DNIComponent } from './Selfie_DNI.component';

describe('Selfie_DNIComponent', () => {
  let component: Selfie_DNIComponent;
  let fixture: ComponentFixture<Selfie_DNIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Selfie_DNIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Selfie_DNIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
