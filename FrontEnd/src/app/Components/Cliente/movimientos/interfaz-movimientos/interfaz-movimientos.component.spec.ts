import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfazMovimientosComponent } from './interfaz-movimientos.component';

describe('InterfazMovimientosComponent', () => {
  let component: InterfazMovimientosComponent;
  let fixture: ComponentFixture<InterfazMovimientosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfazMovimientosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfazMovimientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
