import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientsService } from 'src/app/Service/clients.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-card-cliente',
  templateUrl: './card-cliente.component.html',
  styleUrls: ['./card-cliente.component.css'],
})
export class CardClienteComponent {
  saldo: boolean = true;
  client: IClient = {
    id: 0,
    userName: '',
    balance: 0,
    accountNumber: 0,
    active: true,
    alias: '',
    qr: '',
  };

  constructor(private clientService: ClientsService) {}

  ngOnInit() {
    this.clientService.getClientId(2).subscribe((client) => {
      this.client = client;
      console.log(client);
    });
  }
}
