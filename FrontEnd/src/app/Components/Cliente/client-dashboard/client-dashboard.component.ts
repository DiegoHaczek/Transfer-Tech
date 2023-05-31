import { Component } from '@angular/core';

import { ChartData, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css'],
})
export class ClientDashboardComponent {
  expensesData: ChartData<'pie'> = {
    labels: ['Comida', 'Bienestar', 'Estudio', 'Transporte', 'Vivienda'],
    datasets: [
      {
        data: this.generateRandomExpenses(),
        backgroundColor: [
          '#09004D',
          '#424BF5',
          '#2A28D1',
          '#7F87FC',
          '#A6A9FC',
        ],
      },
    ],
  };

  chartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      title: {
        display: true,
        text: 'Total Expenses by Category',
      },
    },
  };

  generateRandomExpenses(): number[] {
    const expenses: number[] = [];
    for (let i = 0; i < 5; i++) {
      expenses.push(Math.floor(Math.random() * 1000) + 1); // Generar un número aleatorio entre 1 y 1000 para cada categoría
    }
    return expenses;
  }
}
