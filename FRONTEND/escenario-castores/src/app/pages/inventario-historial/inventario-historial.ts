import { Component, OnInit, signal, ChangeDetectorRef } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Movimientos } from '../../services/movimientos/movimientos';

import { HttpClientModule } from '@angular/common/http';

import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-inventario-historial',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
  ],
  templateUrl: './inventario-historial.html',
  styleUrl: './inventario-historial.css',
})
export class InventarioHistorial implements OnInit {

  movimientos: any[] = [];
  movimiento: any;

  tipoMovimiento: any;

  constructor(
    public Movimientos: Movimientos,
    private cdr: ChangeDetectorRef
  ) {

  }

  ngOnInit(): void {
    this.tipoMovimiento = 1;
    this.obtenerMovimientos(this.tipoMovimiento);

  }

  obtenerMovimientos(tipoMovimiento: number): void {

    this.Movimientos.obtenerMovimientos(tipoMovimiento).subscribe(
      {
        next: (resp) => {
          this.movimientos = resp;
          this.cdr.detectChanges();

        },
        error: (error) => { console.error(error) }
      }
    )
  }

  seleccionTipoDeMovimiento(event: Event): void {
    this.tipoMovimiento = Number((event.target as HTMLSelectElement).value);
    this.obtenerMovimientos(this.tipoMovimiento);
  }
}
