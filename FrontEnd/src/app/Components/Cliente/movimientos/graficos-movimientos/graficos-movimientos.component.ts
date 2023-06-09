import { Component, Input } from '@angular/core';
import { ChartData, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-graficos-movimientos',
  templateUrl: './graficos-movimientos.component.html',
  styleUrls: ['./graficos-movimientos.component.css']
})
export class GraficosMovimientosComponent {
  @Input() transferencias: any;
  expensesData: ChartData<'pie'> = {
    labels: ['Comida', 'Bienestar', 'Estudio', 'Transporte', 'Vivienda', 'Otros'],
    datasets: [
      {
        data: this.generateRandomExpenses(),
        backgroundColor: [
          '#09004D',
          '#424BF5',
          '#2A28D1',
          '#7F87FC',
          '#A6A9FC',
          '#EAEAFF',
        ],
      },
    ],
  };

  chartOptions: ChartOptions = {
    responsive: true,
    
  };

  generateRandomExpenses(): number[] {
    const expenses: number[] = [];
    for (let i = 0; i < 6; i++) {
      expenses.push(Math.floor(Math.random() * 1000) + 1); // Generar un número aleatorio entre 1 y 1000 para cada categoría
    }
    return expenses;
  }
}

