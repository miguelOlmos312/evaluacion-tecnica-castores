import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InventarioSalida } from './inventario-salida';

describe('InventarioSalida', () => {
  let component: InventarioSalida;
  let fixture: ComponentFixture<InventarioSalida>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InventarioSalida],
    }).compileComponents();

    fixture = TestBed.createComponent(InventarioSalida);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
