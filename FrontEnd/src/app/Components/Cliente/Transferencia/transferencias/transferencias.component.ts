import { Component, ViewEncapsulation } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';

import { DataTransportService } from 'src/app/Service/data-transport.service';
@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css'],
})
export class TransferenciasComponent  {
  transfer: any;
  

  constructor(private clientService: ClientsService, private transport: DataTransportService) {}

  ngOnInit() {
   
    this.cargarRecientes();
    
    
  }

  cargarRecientes() {
    this.clientService.getTransfers(1).subscribe((data) => {
      this.transfer = data.slice(-4);
    });
  } 
  cargarId() {
    const id = this.transport.obtenerDato('id') 
    console.log(id);
  }

  
  PasarInfo(id: number) {
    this.transport.guardarDato('id', id);
    
       }
}
