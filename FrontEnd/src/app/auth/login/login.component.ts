import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required),
  });
  constructor(private router: Router, private authService: AuthService) {}

  loginSubmit() {
    const email = this.loginForm.get('email')?.value || '';
    const password = this.loginForm.get('password')?.value || '';
    this.authService.login(email, password).subscribe(
      (response) => {
        // Handle successful login
        this.router.navigate(['/cliente']);
      },
      (error) => {
        // Handle login error
        console.error(error);
      }
    );
  }
  getIdFromLocalStorage(): any {
    return localStorage.getItem('id');
  }
}
