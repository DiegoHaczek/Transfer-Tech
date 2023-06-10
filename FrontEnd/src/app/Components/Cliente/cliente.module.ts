import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteRoutingModule } from './cliente-routing.module';

// Componentes

import { CardClienteComponent } from './inicio/card-cliente/card-cliente.component';
import { MontoTransferenciaComponent } from './Transferencia/monto-transferencia/monto-transferencia.component';
import { TransferenciasComponent } from './Transferencia/transferencias/transferencias.component';
import { NuevaCuentaComponent } from './Transferencia/nueva-cuenta/nueva-cuenta.component';
import { ComprobanteComponent } from './Transferencia/comprobante/comprobante.component';
import { ConfirmacionTransferenciasComponent } from './Transferencia/confirmacion-transferencias/confirmacion-transferencias.component';
import { DatosCuentaComponent } from './Transferencia/datos-cuenta/datos-cuenta.component';
import { pipeTransaccion } from 'src/app/Utils/pipeTransaccion';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgChartsModule } from 'ng2-charts';
import { PrincipalComponent } from './Perfil/principal/principal.component';
import { IdentificacionesComponent } from './Perfil/identificaciones/identificaciones.component';
import { TarjetasComponent } from './Perfil/tarjetas/tarjetas.component';
import { DatosDeCuentaComponent } from './Perfil/datos-de-cuenta/datos-de-cuenta.component';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { InterfazClienteComponent } from './inicio/interfaz-cliente/interfaz-cliente.component';
import { TableTransferenciaComponent } from './inicio/table-transferencia/table-transferencia.component';
import { DepositoComponent } from './Transferencia/deposito/deposito.component';
import { InterfazMovimientosComponent } from './movimientos/interfaz-movimientos/interfaz-movimientos.component';
import { TablaMovimientosComponent } from './movimientos/tabla-movimientos/tabla-movimientos.component';
import { GraficosMovimientosComponent } from './movimientos/graficos-movimientos/graficos-movimientos.component';
import { SharedModule } from 'src/app/shared/shared.module';


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
  pipeTransaccion,
  PrincipalComponent,
  IdentificacionesComponent,
  TarjetasComponent,
  DatosDeCuentaComponent,
  DepositoComponent,
  PrincipalComponent,
  InterfazMovimientosComponent,
  TablaMovimientosComponent,
  GraficosMovimientosComponent,
];

@NgModule({
  declarations: [Cliente, ],
  providers: [DataTransportService],
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
