import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';

@Component({
  selector: 'app-Datos_Personales',
  templateUrl: './Datos_Personales.component.html',
  styleUrls: ['./Datos_Personales.component.css']
})
  export class Datos_PersonalesComponent implements OnInit {
    profileForm!: FormGroup;
  
    constructor(
      private formBuilder: FormBuilder,
      private service: ClientsService,
      private router:Router
    ) {}
  
    ngOnInit() {
      this.profileForm = this.formBuilder.group({
        dni: ['', Validators.required],
        name: ['', Validators.required],
        dateOfBirth: ['', Validators.required]
      });
    }
    formatDni() {
      let dniValue = this.profileForm.get('dni')?.value;
      dniValue = dniValue.replace(/\D/g, ''); 
      dniValue = dniValue.slice(0, 8); 
    
      if (dniValue.length > 2) {
        dniValue = dniValue.slice(0, 2) + '.' + dniValue.slice(2); 
      }
      if (dniValue.length > 6) {
        dniValue = dniValue.slice(0, 6) + '.' + dniValue.slice(6); 
      }
    
      this.profileForm.get('dni')?.setValue(dniValue, { emitEvent: false }); 
    }
    enviarDatos() {
      const Id = localStorage.getItem('newId');
      const id = Id ? parseInt(Id) : 0;
      const body = {
        dni: this.profileForm.value.dni,
        name: this.profileForm.value.name,
        date_of_birth: this.profileForm.value.dateOfBirth
      };
  
      this.service.createPerfil(id, body).subscribe(
        (response) => {
          this.router.navigate(['/register/5'])
        },
        (error) => {
          console.error('Error:', error);
        }
      );
    }
  }