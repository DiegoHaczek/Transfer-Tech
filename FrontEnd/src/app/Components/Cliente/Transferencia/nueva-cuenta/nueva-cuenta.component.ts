import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-nueva-cuenta',
  templateUrl: './nueva-cuenta.component.html',
  styleUrls: ['./nueva-cuenta.component.css']
})
export class NuevaCuentaComponent {
valor:any
id:any
constructor(private clientService: ClientsService, private transport: DataTransportService) {}
obtenerValor() {
  if (this.valor) {
    if (isNaN(Number(this.valor))) {
      this.metodoAlias();
    } else {
      this.metodoCBU();
    }
  }
}
metodoCBU() {
  

  this.clientService.getClientCVU(this.valor)
    .subscribe(
      (response) => {
        this.id = response.id;
        this.PasarInfo(this.id);
       
      },
      (error) => {
        console.log(error);
      }
    );
}

metodoAlias() {

  

  this.clientService.getClientAlias(this.valor)
    .subscribe(
      (response) => {
        this.id = response.id;
        this.PasarInfo(this.id);
      },
      (error) => {
        console.log(error);
      }
    );
}
PasarInfo(id: number) {
  this.transport.guardarDato('id', id);
  
     }
}
  

