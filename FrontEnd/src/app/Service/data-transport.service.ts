import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DataTransportService {
  private photos: File[] =[]

  guardarDato(clave: string, valor: any): void {
    localStorage.setItem(clave, valor);
  }

  obtenerDato(clave: string): any {
    return localStorage.getItem(clave);
  }

  eliminarDato(clave: string): void {

    localStorage.removeItem(clave);
  }

  setPhoto( photo: File) {
    this.photos.push(photo);
  }

  getPhotos() {
    return this.photos;
  }

  clearPhotos() {
    this.photos = [];
  }
}
