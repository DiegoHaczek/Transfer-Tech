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
  loginForm = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [
      Validators.required,
      Validators.minLength(8),
    ]),
  });
  constructor(private router: Router, private authService: AuthService) {}
  loginSubmit() {
    // Verificar si el formulario es válido
    if (this.loginForm.valid) {
      // Obtener los valores del formulario
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
      // Verificar si el mail no es nulo
      if (email != null && password != null) {
        // Llamar al método de inicio de sesión del servicio de autenticación
        this.authService.login(email, password).subscribe({
          next: (response) => {
            // Manejar la respuesta exitosa del servidor
            console.log('Inicio de sesión exitoso:', response);
            // Redirigir al usuario a la página de inicio
            this.router.navigate(['/user']);
          },
          error: (error) => {
            // Manejar el error de inicio de sesión
            console.error('Error de inicio de sesión:', error);
            // Mostrar un mensaje de error al usuario
            alert('Error de inicio de sesión. Por favor, inténtelo de nuevo.');
          },
        });
      }
    }
  }
  getUserIdFromLocalStorage(): string {
    return localStorage.getItem('userId') || '';
  }
}
