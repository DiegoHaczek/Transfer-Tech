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
 constructor(private clientService: ClientsService, ) {}

 ngOnInit() {
   this.clientService.getId(2).subscribe( (data) => {
     this.cuenta = data;
     console.log(this.cuenta);
   });
 
} 
}
