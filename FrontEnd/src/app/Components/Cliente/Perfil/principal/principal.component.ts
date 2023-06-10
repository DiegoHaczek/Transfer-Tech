import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
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
    cardActive: true,
    cardCvv: 0,
    cardExpiration: '',
    cardIssuance: '',
    cardNumber: '',
  };

  constructor(private clientService: ClientsService, private transport: DataTransportService, private snackBar: MatSnackBar ) {}

  ngOnInit() {
    this.clientService.getClientId(this.transport.obtenerDato('id')).subscribe( (client) => {
      this.client = client;
      console.log(client);
    });
  }
  botonDecorativo(){
    this.snackBar.open('Esta funcionalidad todavia esta en desarrollo, proximamente estara disponible', 'Cerrar', {
      duration: 3000,
      verticalPosition: 'top',
    });
  }
 
}
