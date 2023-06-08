import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataTransportService {
  guardarDato(clave: string, valor: any): void {
    localStorage.setItem(clave, valor);
  }

  obtenerDato(clave: string): any {
    return localStorage.getItem(clave);
  }

  eliminarDato(clave: string): void {
    localStorage.removeItem(clave);
  }

  
}
