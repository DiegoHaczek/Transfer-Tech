import { Component, ViewChild, ViewEncapsulation } from '@angular/core';
import { ClientsService } from 'src/app/Service/clients.service';
import { ITransfer } from 'src/app/models/itransfer';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-table-transferencia',
  templateUrl: './table-transferencia.component.html',
  styleUrls: ['./table-transferencia.component.css'],
  encapsulation: ViewEncapsulation.None,
 
})
export class TableTransferenciaComponent {
 transfer: any;




  constructor(private clientService: ClientsService) {}
  ngOnInit() {
    this.cargar()
    
  }
 
  cargar(){
    this.clientService.getTransfers().subscribe((data) => {
      this.transfer = data.slice(-5);
     
    });
  }
  
}
