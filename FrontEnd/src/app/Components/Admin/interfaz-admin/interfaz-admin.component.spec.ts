import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfazAdminComponent } from './interfaz-admin.component';

describe('InterfazAdminComponent', () => {
  let component: InterfazAdminComponent;
  let fixture: ComponentFixture<InterfazAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfazAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfazAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
