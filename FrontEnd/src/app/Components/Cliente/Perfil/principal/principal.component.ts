import { Component } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {
  client: IClient = {
    id: 0,
    userName: '',
    balance: 0,
    accountNumber: 0,
    active: true,
    alias: '',
    qr: '',
  };

  constructor(private clientService: ClientsService, ) {}

  ngOnInit() {
    this.clientService.getClientId(2).subscribe( (client) => {
      this.client = client;
      console.log(client);
    });
  }
  
 
}
