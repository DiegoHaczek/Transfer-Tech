import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-Primer_Email',
  templateUrl: './Primer_Email.component.html',
  styleUrls: ['./Primer_Email.component.css'],
})
export class Primer_EmailComponent {
 
  registerForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required),
  });

  constructor(private router: Router, private authService: AuthService,  private snackBar: MatSnackBar) {}
  registerSubmit() {
    const email = this.registerForm.value.email;
    const password = this.registerForm.value.password;
  
    this.authService.register(email, password).subscribe(
      (response) => {
        
        const { user_id, verification_code, token } = response;
        localStorage.setItem('newId', user_id);
        localStorage.setItem('verification_code', verification_code);
this.router.navigate(['/register/3'])


      },
      (error) => {
        this.snackBar.open('Ese correo ya esta asociado a otra cuenta. Por favor, inténtalo nuevamente.', 'Cerrar', {
          duration: 3000,
          verticalPosition: 'top',
        });
      }
    );
  }
}
