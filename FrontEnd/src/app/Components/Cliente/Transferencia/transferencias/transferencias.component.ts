import { Component, ViewEncapsulation } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';

@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css'],
  
})
export class TransferenciasComponent {
  transfer: any;




  constructor(private clientService: ClientsService) {}
  ngOnInit() {
    this.cargar()
   
  }
 
  cargar(){
    this.clientService.getTransfers().subscribe((data) => {
      this.transfer = data.slice(-4);
     
    });
  }
}
