import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientsService } from 'src/app/Service/clients.service';
import { IClient } from 'src/app/models/iclient';
@Component({
  selector: 'app-card-cliente',
  templateUrl: './card-cliente.component.html',
  styleUrls: ['./card-cliente.component.css'],
})
export class CardClienteComponent {
  saldo: boolean = true;
  client: IClient = {
    id: 0,
    name: '',
    credit: 0,
    account: 0,
    cvu: 0,
    alias: '',
  };

  constructor(private clientService: ClientsService) {}

  ngOnInit() {
    this.clientService.getClient().subscribe((client) => {
      this.client = client;
      console.log(client);
    });
  }
}
