import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import * as _ from 'lodash';
import { DataTransportService } from 'src/app/Service/data-transport.service';
@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css'],
})
export class TransferenciasComponent {
  transfer: any;

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService
  ) {}

  ngOnInit() {
    this.cargarRecientes();
  }

  cargarRecientes() {
    this.clientService
      .getTransfers(this.transport.obtenerDato('id'))
      .subscribe((data) => {
        const sortedData = _.orderBy(data, 'dateTime', 'desc');

        this.transfer = _.uniqBy(
          sortedData.filter((item) => item.userName !== ''),
          'userName'
        );
      });
  }
  cargarId() {
    const id = this.transport.obtenerDato('id');
  }

  PasarInfo(id: number) {
    this.transport.guardarDato('idReceptor', id);
  }
  
}
