import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-Dorso_DNI',
  templateUrl: './Selfie_DNI.component.html',
  styleUrls: ['./Selfie_DNI.component.css'],
})
export class Selfie_DNIComponent implements OnInit {
  dropzoneColor = '#e5e5e5';
  value: string = '';
  files: File | null = null;
 mostrarSpinner= false
    
  
  constructor(
    private photoService: DataTransportService,
    private router: Router,
    private snackBar: MatSnackBar,
    private service: AuthService
  ) {}

  ngOnInit() {


  }
  onFileDropped(event: any) {
    event.preventDefault();
    event.stopPropagation();

    const files = event.dataTransfer.files;
    if (files.length > 0) {
      return (this.files = files[0]);
    }
  }

  onDragOver(event: any) {
    event.preventDefault();
    event.stopPropagation();
    this.dropzoneColor = '#525252';
    event.target.classList.add('dragover');
  }

  onDragLeave(event: any) {
    event.preventDefault();
    event.stopPropagation();
    this.dropzoneColor = '#e5e5e5';
    event.target.classList.remove('dragover');
  }
  onInputChange(event: any) {
    const files = event.target.files;
    if (files.length > 0) {
      return (this.files = files[0]);
    }
  }
  continuar() {
    
    if (this.files) {
      this.mostrarSpinner=true
      this.photoService.setPhoto( this.files);
    const datos = this.photoService.getPhotos();
        const Id = localStorage.getItem('newId');
        const id = Id ? parseInt(Id) : 0;
       
        this.service.approvalRegister(id, datos).subscribe(
          (response) => {
            if(response.message[0].includes("is valid") ) {
              this.snackBar.open('Cuenta creada con exito' , 'Cerrar'),
            {
              duration: 3000,
              verticalPosition: 'top',
            };
            this.photoService.clearPhotos();
            this.router.navigate(['/login']);
            }
            else{
              this.snackBar.open(response.message, 'Cerrar'),
              {
                duration: 3000,
                verticalPosition: 'top',
              };
              this.photoService.clearPhotos();
              this.router.navigate(['/register/5']);
            }
            console.log("respuesta", response.message[0].includes("is valid"))
            console.log("respuesta", response.message[0])
          },
          (error) => {
            this.snackBar.open('Error desconocido, intenta con imagenes de menor tamaño' , 'Cerrar'),
            {
              duration: 3000,
              verticalPosition: 'top',
            };
            this.router.navigate(['/register/5']);
          }
        );
      
    } else {
      this.snackBar.open('Por favor, ingrese una imagen', 'Cerrar'),
        {
          duration: 3000,
          verticalPosition: 'top',
        };
        this.mostrarSpinner=false

    }
    
  }
}
