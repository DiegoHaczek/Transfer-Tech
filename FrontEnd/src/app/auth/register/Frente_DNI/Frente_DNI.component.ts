import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-Frente_DNI',
  templateUrl: './Frente_DNI.component.html',
  styleUrls: ['./Frente_DNI.component.css'],
})
export class Frente_DNIComponent implements OnInit {
  dropzoneColor = '#e5e5e5';
  value: string = '';
  files: File | null = null;
  constructor(
    private photoService: DataTransportService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit() {}
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
      this.router.navigate(['/register/6']);
   
      this.photoService.setPhoto( this.files);
    }
    else{
      this.snackBar.open('Por favor, ingrese una imagen', 'Cerrar'), {
        duration: 3000,
        verticalPosition: 'top',
    }
  }
} }
