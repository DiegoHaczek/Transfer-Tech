import { Component, ViewEncapsulation } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';

@Component({
  selector: 'app-table-transferencia',
  templateUrl: './table-transferencia.component.html',
  styleUrls: ['./table-transferencia.component.css'],
  encapsulation: ViewEncapsulation.None,
 
})
export class TableTransferenciaComponent {
 transfer: any;




  constructor(private clientService: ClientsService) {}
  ngOnInit() {
    this.cargar()
    
  }
 
  cargar(){
    this.clientService.getTransfers(2).subscribe((data) => {
      this.transfer = data.slice(-5);
     
    });
  }
  
}
