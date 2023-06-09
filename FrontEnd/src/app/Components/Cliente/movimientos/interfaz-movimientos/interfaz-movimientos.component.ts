import { Component } from '@angular/core';
import * as _ from 'lodash';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-interfaz-movimientos',
  templateUrl: './interfaz-movimientos.component.html',
  styleUrls: ['./interfaz-movimientos.component.css']
})
export class InterfazMovimientosComponent {
  transfer: any;

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService
  ) {}
  ngOnInit() {
    this.cargar();
  }

  cargar() {
    this.clientService
      .getTransfers(this.transport.obtenerDato('id'))
      .subscribe((data) => {
        this.transfer = _.orderBy(data, 'dateTime', 'asc');
      
       
      });
  }
}
