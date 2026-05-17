import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { Auth } from '../../services/auth/auth';

import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login implements OnInit {

  loginForm!: FormGroup;

  usuarioLogeado: any;

  constructor(
    public fb: FormBuilder,
    public Auth: Auth,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {

  }
  ngOnInit(): void {

    this.loginForm = this.fb.group({
      correo: [, Validators.required],
      contrasena: ['', Validators.required],
    });

  }

  login(): void {
    this.Auth.login(this.loginForm.value.correo, this.loginForm.value.contrasena).subscribe(
      resp => {
        this.usuarioLogeado = resp;
        if (this.usuarioLogeado != null) {
          this.router.navigate(['/home']);
        }

      }, error => { console.error(error) })
  }


}
