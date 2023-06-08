import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-monto-transferencia',
  templateUrl: './monto-transferencia.component.html',
  styleUrls: ['./monto-transferencia.component.css'],
})
export class MontoTransferenciaComponent {
  id: string = '';
  idReceptor: string = '';
  valor: number = 0;
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
    receiverAccountId: '1',
    description: '.',
    amount: 0,
  };

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router
  ) {}

  ngOnInit() {
    this.id = this.idReceptor = this.transport.obtenerDato('id');
    this.idReceptor = this.transport.obtenerDato('idReceptor');
    this.clientService.getClientId(Number(this.id)).subscribe((client) => {
      this.client = client;
    });
  }
  guardarTransferencia() {
    this.transfer = {
      receiverAccountId: this.idReceptor,
      description: 'Transferencia',
      amount: this.valor,
    };
    this.transport.guardarDato('transfer', JSON.stringify(this.transfer));

    this.router.navigate(['/cliente/transfer/5']);
  }
}
