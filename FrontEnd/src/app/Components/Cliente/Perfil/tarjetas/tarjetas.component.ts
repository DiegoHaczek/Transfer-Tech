import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-tarjetas',
  templateUrl: './tarjetas.component.html',
  styleUrls: ['./tarjetas.component.css'],
})
export class TarjetasComponent {
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

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService
  ) {}

  ngOnInit() {
    this.clientService
      .getClientId(this.transport.obtenerDato('id'))
      .subscribe((client) => {
        this.client = client;
        console.log(client);
      });
  }
}
