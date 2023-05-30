import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from '../inicio/inicio.component';
import { TransferenciasComponent } from './Transferencia/transferencias/transferencias.component';
import { NuevaCuentaComponent } from './Transferencia/nueva-cuenta/nueva-cuenta.component';
import { DatosCuentaComponent } from './Transferencia/datos-cuenta/datos-cuenta.component';
import { MontoTransferenciaComponent } from './Transferencia/monto-transferencia/monto-transferencia.component';
import { ConfirmacionTransferenciasComponent } from './Transferencia/confirmacion-transferencias/confirmacion-transferencias.component';
import { ComprobanteComponent } from './Transferencia/comprobante/comprobante.component';

const routes: Routes = [
  {
    path: '',
    component: InicioComponent,
  },
  {
    path: 'transfer/1',
    component: TransferenciasComponent,
  },
  {
    path: 'transfer/2',
    component: NuevaCuentaComponent,
  },
  {
    path: 'transfer/3',
    component: DatosCuentaComponent,
  },
  {
    path: 'transfer/4',
    component: MontoTransferenciaComponent,
  },
  {
    path: 'transfer/5',
    component: ConfirmacionTransferenciasComponent,
  },
  {
    path: 'transfer/6',
    component: ComprobanteComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClienteRoutingModule {}
