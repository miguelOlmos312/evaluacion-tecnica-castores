import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InventarioEntrada } from './inventario-entrada';

describe('InventarioEntrada', () => {
  let component: InventarioEntrada;
  let fixture: ComponentFixture<InventarioEntrada>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InventarioEntrada],
    }).compileComponents();

    fixture = TestBed.createComponent(InventarioEntrada);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
