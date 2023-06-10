import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';

@Component({
  selector: 'app-nueva-cuenta',
  templateUrl: './nueva-cuenta.component.html',
  styleUrls: ['./nueva-cuenta.component.css'],
})
export class NuevaCuentaComponent {
  valor: any;
  id: any;
  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}
  obtenerValor() {
    if (this.valor) {
      if (isNaN(Number(this.valor))) {
        this.metodoAlias();
      } else {
        this.metodoCBU();
      }
      
      
      
    }
  }
  metodoCBU() {
    this.clientService.getClientCVU(this.valor).subscribe(
      (response) => {
        this.id = response.id;
        this.PasarInfo(this.id);
        setTimeout(() => {
          this.router.navigate(['/cliente/transfer/3']);
        }, 1000);
      },
      (error) => {
        this.snackBar.open('Cuenta no encontrada. Por favor, inténtalo nuevamente.', 'Cerrar', {
          duration: 3000,
          verticalPosition: 'top',
        });
      }
    );
    
  }

  metodoAlias() {
    this.clientService.getClientAlias(this.valor).subscribe(
      (response) => {
        this.id = response.id;
        this.PasarInfo(this.id);
        setTimeout(() => {
          this.router.navigate(['/cliente/transfer/3']);
        }, 1000);
      },
      (error) => {
        this.snackBar.open('Cuenta no encontrada. Por favor, inténtalo nuevamente.', 'Cerrar', {
          duration: 3000,
          verticalPosition: 'top',
        });
      }
    );
  }
  PasarInfo(id: string) {
    this.transport.guardarDato('idReceptor', id);
  }
}
