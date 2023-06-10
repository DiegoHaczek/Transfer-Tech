import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-confirmacion-transferencias',
  templateUrl: './confirmacion-transferencias.component.html',
  styleUrls: ['./confirmacion-transferencias.component.css'],
})
export class ConfirmacionTransferenciasComponent {
  id: number = 0;
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
    cardActive: true,
    cardCvv: 0,
    cardExpiration: '',
    cardIssuance: '',
    cardNumber: '',
  };
  transfer = {
    receiverAccountId: '',
    description: '',
    amount: 0,
  };

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router
  ) {}

  ngOnInit() {
    this.obtenerData();

    this.clientService
      .getClientId(Number(this.idReceptor))
      .subscribe((client) => {
        this.client = client;
      });
  }
  obtenerData() {
    this.id = this.transport.obtenerDato('id');
    this.idReceptor = this.transport.obtenerDato('idReceptor');
    const transferStr = this.transport.obtenerDato('transfer');
    if (transferStr) {
      this.transfer = JSON.parse(transferStr);
      console.log(this.transfer);
    }
  }
  confirmarTransferencia() {
    this.clientService.tranferir(this.id, this.transfer).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.error(error);
      }
    );
    this.router.navigate(['/cliente/transfer/6']);
  }
}
