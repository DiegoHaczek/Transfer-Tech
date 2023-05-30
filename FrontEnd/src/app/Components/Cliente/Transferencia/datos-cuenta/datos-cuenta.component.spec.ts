import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatosCuentaComponent } from './datos-cuenta.component';

describe('DatosCuentaComponent', () => {
  let component: DatosCuentaComponent;
  let fixture: ComponentFixture<DatosCuentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatosCuentaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatosCuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
