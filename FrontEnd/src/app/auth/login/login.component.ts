import { Component, } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent  {
  loginForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required)
  });

  constructor(
    private router: Router,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) {}

 

  loginSubmit() {
    if (this.loginForm && this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;
  
      if (email != null && password != null) {
        this.authService.login(email, password).subscribe(
          (response) => {
            this.router.navigate(['/cliente']);
            
          },
          (error) => {
            this.snackBar.open('Credenciales inválidas. Por favor, inténtalo nuevamente.', 'Cerrar', {
              duration: 3000,
              verticalPosition: 'top',
            });
          }
        );
      }
    }
  }

  
}