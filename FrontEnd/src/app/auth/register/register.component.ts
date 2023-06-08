import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/Service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  email: any;
  password: any;
  loginForm = new FormGroup({
    email: new FormControl(' '),
    password: new FormControl(' '),
  });
  constructor(private router: Router, private authService: AuthService) {}
  loginSubmit() {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;
    console.log(email, password);
    // Verificar si el mail no es nulo
    if (email != null && password != null) {
      // Llamar al método de inicio de sesión del servicio de autenticación
      this.authService.login(email, password).subscribe(
        (response) => {
          console.log(response);
        },
        (error) => {
          console.error(error);
        }
      );
    }
  }
  getUserIdFromLocalStorage(): string {
    return localStorage.getItem('id') || '';
  }
}
