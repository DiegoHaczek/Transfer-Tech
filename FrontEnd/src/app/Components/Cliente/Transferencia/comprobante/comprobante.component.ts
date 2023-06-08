import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-comprobante',
  templateUrl: './comprobante.component.html',
  styleUrls: ['./comprobante.component.css'],
})
export class ComprobanteComponent {
  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router
  ) {}

  idReceptor: string = '';

  client: IClient = {
    id: 0,
    userName: '',
    balance: 0,
    accountNumber: 0,
    active: true,
    alias: '',
    qr: '',
  };
  transfer = {
    receiverAccountId: '',
    description: '',
    amount: 0,
  };

  ngOnInit() {
    this.obtenerData();

    this.clientService
      .getClientId(Number(this.idReceptor))
      .subscribe((client) => {
        this.client = client;
      });
  }
  obtenerData() {
    this.idReceptor = this.transport.obtenerDato('idReceptor');
    const transferStr = this.transport.obtenerDato('transfer');
    if (transferStr) {
      this.transfer = JSON.parse(transferStr);
      console.log(this.transfer);
    }
  }
  Inicio() {
    this.transport.eliminarDato('idReceptor');
    this.router.navigate(['/cliente/transfer/6']);
  }
}
