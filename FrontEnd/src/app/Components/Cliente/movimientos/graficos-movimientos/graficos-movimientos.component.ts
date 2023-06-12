import { Component, Input } from '@angular/core';
import { ChartData, ChartOptions } from 'chart.js';
import { ITransfer } from 'src/app/models/itransfer';

@Component({
  selector: 'app-graficos-movimientos',
  templateUrl: './graficos-movimientos.component.html',
  styleUrls: ['./graficos-movimientos.component.css']
})
export class GraficosMovimientosComponent {
  @Input() transferencias!: ITransfer[];
  transferenciasFiltradas!: ITransfer[];
  expensesData: ChartData<'pie', number[], unknown> = {
    labels: ['Comida', 'Bienestar', 'Estudio', 'Transporte', 'Vivienda', 'Otros'],
    datasets: [
      {
        data: [],
        backgroundColor: [
          '#C8CB3B',
          '#A6A9FC',
          '#D19843',
          '#C54600',
          '#007D00',
          '#1700C0',
        ],
      },
    ],
  };

  chartOptions: ChartOptions = {
    responsive: true,
  };

  ngOnChanges() {
    this.filtrarTransferencias();
  }

  filtrarTransferencias() {
    this.transferenciasFiltradas = this.transferencias.filter(transferencia => transferencia.type === 'Transferencia Enviada');

    const sumsByDescription: { [key: string]: number } = {};
    const descripcionesPosibles = ['Comida', 'Bienestar', 'Estudio', 'Transporte', 'Vivienda', 'Otros'];
    
    for (const descripcion of descripcionesPosibles) {
      sumsByDescription[descripcion] = 0;
    }
  
    for (const transferencia of this.transferenciasFiltradas) {
      const descripcion = transferencia.description;
      const amount = transferencia.amount;
      sumsByDescription[descripcion] += amount;
    }
    
    this.expensesData.datasets[0].data = descripcionesPosibles.map(descripcion => sumsByDescription[descripcion]);
  }
}
