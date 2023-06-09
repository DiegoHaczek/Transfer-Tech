import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfazClienteComponent } from './interfaz-cliente.component';

describe('InterfazClienteComponent', () => {
  let component: InterfazClienteComponent;
  let fixture: ComponentFixture<InterfazClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfazClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfazClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
