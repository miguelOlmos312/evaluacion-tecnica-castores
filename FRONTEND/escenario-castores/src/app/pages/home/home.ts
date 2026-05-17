import { Component, OnInit, signal, ChangeDetectorRef } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { Auth } from '../../services/auth/auth';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink,
    CommonModule
  ],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  usuario: any;
  permisosIds: any;

  constructor(
    public auth: Auth,
    private router: Router
  ) {

    this.auth.respuesta$.subscribe(respuesta => {
      if (respuesta) {
        this.usuario = respuesta.usuario;
        this.permisosIds = respuesta.permisosIds;
      }
    });
  }
  ngOnInit(): void {


  }



  cerrarSesion(): void {
    this.auth.cerrarSesión();
    this.router.navigate(['/login']);

  }

}
