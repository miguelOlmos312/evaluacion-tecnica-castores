import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Productos {

  private API_SERVER = "http://localhost:8080/productos/";

  constructor(
    private httpClient: HttpClient
  ) { }

  public obtenerProductos(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }

  public obtenerProductosActivos(): Observable<any> {
    return this.httpClient.get(`${this.API_SERVER}productos-activos`);
  }

  public agregarProducto(persona: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER, persona)
  }

  public cambiarEstatus(id: number): Observable<any> {
    return this.httpClient.patch(`${this.API_SERVER}cambiarEstatus/${id}`, {});
  }

  public guardarEntrada(id: number, nuevoStock: number, idUsuario: number): Observable<any> {
    return this.httpClient.patch(`${this.API_SERVER}guardarEntrada/${id}`, { 'nuevoStock': nuevoStock, 'idUsuario': idUsuario });
  }

  public guardarSalida(id: number, nuevoStock: number, idUsuario: number): Observable<any> {
    return this.httpClient.patch(`${this.API_SERVER}guardarSalida/${id}`, { 'nuevoStock': nuevoStock, 'idUsuario': idUsuario });
  }

}
