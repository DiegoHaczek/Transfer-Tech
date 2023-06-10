import { Component, ViewEncapsulation } from '@angular/core';
import * as _ from 'lodash';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-table-transferencia',
  templateUrl: './table-transferencia.component.html',
  styleUrls: ['./table-transferencia.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class TableTransferenciaComponent {
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
        const orderData = _.orderBy(data, 'dateTime', 'asc');
        const shortData = orderData.slice(-5);
        this.transfer = shortData.reverse();
      });
  }
}
