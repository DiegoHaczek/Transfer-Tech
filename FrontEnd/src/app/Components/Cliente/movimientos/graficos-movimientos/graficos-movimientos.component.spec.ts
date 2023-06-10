import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficosMovimientosComponent } from './graficos-movimientos.component';

describe('GraficosMovimientosComponent', () => {
  let component: GraficosMovimientosComponent;
  let fixture: ComponentFixture<GraficosMovimientosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GraficosMovimientosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GraficosMovimientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
