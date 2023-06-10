import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-datos-cuenta',
  templateUrl: './datos-cuenta.component.html',
  styleUrls: ['./datos-cuenta.component.css'],
})
export class DatosCuentaComponent {
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
    private transport: DataTransportService,
    private clientService: ClientsService
  ) {}
  ngOnInit(): void {
    const id = this.transport.obtenerDato('idReceptor');
    this.clientService.getClientId(id).subscribe((client) => {
      this.client = client;
      
    });
  }
}
