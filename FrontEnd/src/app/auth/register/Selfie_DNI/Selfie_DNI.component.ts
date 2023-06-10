import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Dorso_DNI',
  templateUrl: './Selfie_DNI.component.html',
  styleUrls: ['./Selfie_DNI.component.css']
})
export class Selfie_DNIComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  onFileDropped(event: any) {
    event.preventDefault();
    event.stopPropagation();

    const files = event.dataTransfer.files;
    if (files.length > 0) {
      // Aquí puedes hacer algo con los archivos, como subirlos a un servidor o procesarlos localmente.
      console.log(files);
    }
  }

  onDragOver(event: any) {
    event.preventDefault();
    event.stopPropagation();
    // Agrega una clase CSS para resaltar visualmente la zona de arrastre cuando se está pasando por encima.
    event.target.classList.add('dragover');
  }

  onDragLeave(event: any) {
    event.preventDefault();
    event.stopPropagation();
    // Remueve la clase CSS cuando se sale de la zona de arrastre.
    event.target.classList.remove('dragover');
  }
}
