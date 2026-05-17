import { Component, OnInit, signal, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Productos } from '../../services/productos/productos';

import { HttpClientModule } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { AbstractControl } from '@angular/forms';
import { Auth } from '../../services/auth/auth';

@Component({
  selector: 'app-inventario-salida',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
  ],
  templateUrl: './inventario-salida.html',
  styleUrl: './inventario-salida.css',
})
export class InventarioSalida implements OnInit {

  productoForm!: FormGroup;
  productos: any[] = [];
  producto: any;
  modoFormulario: any;
  mostrarBotonCancelar: any;
  stockOriginal: any;
  idProductoSeleccionado: any = -1;
  usuario: any;
  permisosIds: any;

  constructor(
    public fb: FormBuilder,
    public Productos: Productos,
    private cdr: ChangeDetectorRef,
    public auth: Auth
  ) {
    this.auth.respuesta$.subscribe(respuesta => {
      if (respuesta) {
        this.usuario = respuesta.usuario;
        this.permisosIds = respuesta.permisosIds;
      }
    });
  }
  ngOnInit(): void {

    this.productoForm = this.fb.group({
      id_producto: [''],
      nombre: ['', Validators.required],
      precio: [, Validators.required],
      estatus: [1, Validators.required],
      stock: [
        0,
        [
          Validators.required,
          this.stockValidador.bind(this)
        ]
      ]
    });
    this.mostrarBotonCancelar = false;
    this.modoFormulario = 'ninguno';
    this.obtenerProductosActivos();

  }

  stockValidador(control: AbstractControl) {
    if (control.value > this.stockOriginal) {
      return { stockEsMayor: true };
    }
    return null;
  }

  obtenerProductosActivos(): void {
    this.Productos.obtenerProductosActivos().subscribe(
      {
        next: (resp) => {
          this.productos = resp;
          this.cdr.detectChanges();

        },
        error: (error) => { console.error(error) }
      }
    )
  }

  salidaDeProducto(producto: any): void {
    this.modoFormulario = 'salida';
    this.mostrarBotonCancelar = true;
    this.stockOriginal = producto.stock;
    this.idProductoSeleccionado = producto.id_producto;
    this.productoForm.setValue({
      id_producto: producto.id_producto,
      nombre: producto.nombre,
      precio: producto.precio,
      estatus: producto.estatus,
      stock: producto.stock
    })
    this.cdr.detectChanges();
  }

  guardarSalida(): void {
    this.Productos.guardarSalida(this.idProductoSeleccionado, this.productoForm.value.stock, this.usuario.id_usuario).subscribe(
      resp => {
        this.modoFormulario = 'ninguno';
        this.mostrarBotonCancelar = false;
        this.idProductoSeleccionado = -1;
        this.productoForm.reset();
        this.obtenerProductosActivos();
        this.cdr.detectChanges();

      }, error => { console.error(error) })
  }

  cancelarSalida(): void {
    this.modoFormulario = 'ninguno';
    this.mostrarBotonCancelar = false;
    this.idProductoSeleccionado = -1;
    this.productoForm.reset();
    this.cdr.detectChanges();
  }















}
