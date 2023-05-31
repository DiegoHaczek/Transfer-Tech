/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Primer_EmailComponent } from './Primer_Email.component';

describe('Primer_EmailComponent', () => {
  let component: Primer_EmailComponent;
  let fixture: ComponentFixture<Primer_EmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Primer_EmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Primer_EmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
