import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-deposito',
  templateUrl: './deposito.component.html',
  styleUrls: ['./deposito.component.css']
})
export class DepositoComponent {

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
    cardActive: true,
    cardCvv: 0,
    cardExpiration: '',
    cardIssuance: '',
    cardNumber: '',
  };
  transfer = {
    
    amount: 0,
  };

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router
  ) {}

  ngOnInit() {
    this.id  = this.transport.obtenerDato('id');
    this.idReceptor = this.transport.obtenerDato('idReceptor');
    this.clientService.getClientId(Number(this.id)).subscribe((client) => {
      this.client = client;
    });
  }
  depositar() {
    
    this.clientService.depositar(Number(this.id), this.valor).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.error(error);
      }
    );

    this.router.navigate(['/cliente']);
  }
}