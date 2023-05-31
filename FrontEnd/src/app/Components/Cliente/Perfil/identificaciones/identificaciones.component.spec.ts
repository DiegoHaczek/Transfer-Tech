import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdentificacionesComponent } from './identificaciones.component';

describe('IdentificacionesComponent', () => {
  let component: IdentificacionesComponent;
  let fixture: ComponentFixture<IdentificacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IdentificacionesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IdentificacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
