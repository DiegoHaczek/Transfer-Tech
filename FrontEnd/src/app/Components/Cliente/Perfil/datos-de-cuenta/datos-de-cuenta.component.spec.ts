import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatosDeCuentaComponent } from './datos-de-cuenta.component';

describe('DatosDeCuentaComponent', () => {
  let component: DatosDeCuentaComponent;
  let fixture: ComponentFixture<DatosDeCuentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatosDeCuentaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatosDeCuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
