import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteRoutingModule } from './cliente-routing.module';
import { NgChartsModule } from 'ng2-charts';

// Componentes
import { InterfazClienteComponent } from './interfaz-cliente/interfaz-cliente.component';
import { CardClienteComponent } from './card-cliente/card-cliente.component';
import { TableTransferenciaComponent } from './table-transferencia/table-transferencia.component';
import { MontoTransferenciaComponent } from './Transferencia/monto-transferencia/monto-transferencia.component';
import { TransferenciasComponent } from './Transferencia/transferencias/transferencias.component';
import { NuevaCuentaComponent } from './Transferencia/nueva-cuenta/nueva-cuenta.component';
import { ComprobanteComponent } from './Transferencia/comprobante/comprobante.component';
import { ConfirmacionTransferenciasComponent } from './Transferencia/confirmacion-transferencias/confirmacion-transferencias.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { DatosCuentaComponent } from './Transferencia/datos-cuenta/datos-cuenta.component';
import { pipeTransaccion } from 'src/app/Utils/pipeTransaccion';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from 'src/app/shared/shared.module';
import { PrincipalComponent } from './Perfil/principal/principal.component';
import { IdentificacionesComponent } from './Perfil/identificaciones/identificaciones.component';
import { TarjetasComponent } from './Perfil/tarjetas/tarjetas.component';
import { DatosDeCuentaComponent } from './Perfil/datos-de-cuenta/datos-de-cuenta.component';


const Cliente = [
  InterfazClienteComponent,
  CardClienteComponent,
  TableTransferenciaComponent,
  TransferenciasComponent,
  MontoTransferenciaComponent,
  ConfirmacionTransferenciasComponent,
  ComprobanteComponent,
  NuevaCuentaComponent,
  DatosCuentaComponent,
  ClientDashboardComponent,
  pipeTransaccion,
  PrincipalComponent, 
  IdentificacionesComponent, 
  TarjetasComponent, 
  DatosDeCuentaComponent,
];

@NgModule({
  declarations: [Cliente,  ],
  imports: [
    CommonModule,
    ClienteRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    NgChartsModule,
  ],
  exports: [Cliente],
})
export class ClienteModule {}
