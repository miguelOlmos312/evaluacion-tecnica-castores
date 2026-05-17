import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Movimientos {

  private API_SERVER = "http://localhost:8080/movimientos/";

  constructor(
    private httpClient: HttpClient
  ) { }

  public obtenerMovimientos(idTipoMovimiento: number): Observable<any> {
    return this.httpClient.get(`${this.API_SERVER}movimientos-por-tipo-movimiento/${idTipoMovimiento}`);
  }

}
