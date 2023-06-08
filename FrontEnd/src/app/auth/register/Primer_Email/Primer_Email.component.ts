import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-Primer_Email',
  templateUrl: './Primer_Email.component.html',
  styleUrls: ['./Primer_Email.component.css'],
})
export class Primer_EmailComponent {
  email: any;
  password: any;
  registerForm = new FormGroup({
    email: new FormControl(' '),
    password: new FormControl(' '),
  });

  constructor(private router: Router, private authService: AuthService) {}
  registerSubmit() {
    const email = 'rami22@maill.com';
    const password = '12345678';

    this.authService.register(email, password).subscribe(
      (response) => {
        console.log('Respuesta:', response);
        // Aquí puedes guardar la respuesta en la variable de tu componente o realizar otras acciones necesarias
      },
      (error) => {
        console.error('Error:', error);
      }
    );
  }
}
