import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';

@Component({
  selector: 'app-nueva-cuenta',
  templateUrl: './nueva-cuenta.component.html',
  styleUrls: ['./nueva-cuenta.component.css']
})
export class NuevaCuentaComponent {
valor:any
aliasInfo:any
constructor(private clientService: ClientsService) {}
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
 
}

metodoAlias() {

  const alias = this.valor;

  this.clientService.getClientAlias(this.valor)
    .subscribe(
      (response) => {
        this.aliasInfo = response;
        console.log(this.aliasInfo);
      },
      (error) => {
        console.log(error);
      }
    );
}
}
  

