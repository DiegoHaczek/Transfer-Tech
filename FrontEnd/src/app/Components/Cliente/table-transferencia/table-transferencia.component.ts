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
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class TableTransferenciaComponent {
 transfer: any;
 columnsToDisplay: string[] = [
  'name',
  'monto',
  'fecha',
]

table = new MatTableDataSource<ITransfer>();

@ViewChild(MatPaginator) paginator!: MatPaginator
@ViewChild(MatSort) sort!: MatSort;
  constructor(private clientService: ClientsService) {}
  ngOnInit() {
    this.cargar()
    console.log(this.table)
  }
  ngAfterViewInit() {
    this.table.paginator = this.paginator;
    this.table.sort = this.sort;
    if(this.table.data.length > 0) {
      this.paginator._intl.itemsPerPageLabel = 'Ver'
    }
  }
  cargar(){
    this.clientService.getTransfers().subscribe((data) => {
      this.transfer = data.slice(-5);
      this.table.data= this.transfer.slice(-5)
    });
  }
  
}
