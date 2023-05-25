import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MontoTransferenciaComponent } from './monto-transferencia.component';

describe('MontoTransferenciaComponent', () => {
  let component: MontoTransferenciaComponent;
  let fixture: ComponentFixture<MontoTransferenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MontoTransferenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MontoTransferenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
