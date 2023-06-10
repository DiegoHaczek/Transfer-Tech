import { Component, Input, OnInit } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-datos-de-cuenta',
  templateUrl: './datos-de-cuenta.component.html',
  styleUrls: ['./datos-de-cuenta.component.css']
})


export class DatosDeCuentaComponent   {
 cuenta: any
 constructor(private clientService: ClientsService, private transport: DataTransportService ) {}

 ngOnInit() {
   this.clientService.getId(this.transport.obtenerDato('id')).subscribe( (data) => {
     this.cuenta = data;
     
   });
 
} 
}
