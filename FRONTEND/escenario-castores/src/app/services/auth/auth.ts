import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { LoginRespuesta } from '../../interfaces/login-respuesta.interface';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private API_SERVER = "http://localhost:8080/auth/";
  private respuestaSub = new BehaviorSubject<any>(null);
  respuesta$ = this.respuestaSub.asObservable();

  constructor(
    private httpClient: HttpClient
  ) { }

  public login(correo: String, contrasena: String): Observable<LoginRespuesta> {
    return this.httpClient.post(`${this.API_SERVER}login`, { 'correo': correo, 'contrasena': contrasena }).pipe(
      tap((respuesta: any) => {
        if (respuesta?.usuario) {
          this.respuestaSub.next(respuesta);
          localStorage.setItem('usuario', JSON.stringify(respuesta.usuario));
          localStorage.setItem('permisosIds', JSON.stringify(respuesta.permisosIds));
          localStorage.setItem('estaLoggeado', 'true');
        }
      }));
  }



  cerrarSesión() {
    this.respuestaSub.next(null);
    localStorage.removeItem('usuario');
    localStorage.removeItem('permisosIds');
    localStorage.removeItem('estaLoggeado');
  }

  usuarioEstaLoggeado(): boolean {
    return localStorage.getItem('estaLoggeado') === 'true';
  }

  tienePermiso(permisoId: number): boolean {
    const permisos = localStorage.getItem('permisosIds');
    if (permisos == null) return false;

    const permisosIds: number[] = JSON.parse(permisos);
    return permisosIds.includes(permisoId);
  }

}
