import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SharedModule } from './shared/shared.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InicioComponent } from './Components/inicio/inicio.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { InterfazClienteComponent } from './Components/Cliente/interfaz-cliente/interfaz-cliente.component';
import { InterfazAdminComponent } from './Components/Admin/interfaz-admin/interfaz-admin.component';
import { CardClienteComponent } from './Components/Cliente/card-cliente/card-cliente.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TableTransferenciaComponent } from './Components/Cliente/table-transferencia/table-transferencia.component';
import { pipeTransaccion } from './Utils/pipeTransaccion';
import { ClientDashboardComponent } from './Components/client-dashboard/client-dashboard.component';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';
import { TransferenciasComponent } from './Components/Cliente/Transferencia/transferencias/transferencias.component';
import { NuevaCuentaComponent } from './Components/Cliente/Transferencia/nueva-cuenta/nueva-cuenta.component';
import { AuthModule } from './auth/auth.module';
import { DatosCuentaComponent } from './Components/Cliente/Transferencia/datos-cuenta/datos-cuenta.component';
import { MontoTransferenciaComponent } from './Components/Cliente/Transferencia/monto-transferencia/monto-transferencia.component';
import { ConfirmacionTransferenciasComponent } from './Components/Cliente/Transferencia/confirmacion-transferencias/confirmacion-transferencias.component';
import { ComprobanteComponent } from './Components/Cliente/Transferencia/comprobante/comprobante.component';


@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    HeaderComponent,
    FooterComponent,
    InterfazClienteComponent,
    InterfazAdminComponent,
    CardClienteComponent,
    TableTransferenciaComponent,
    pipeTransaccion,
    ClientDashboardComponent,
    PageNotFoundComponent,
    TransferenciasComponent,
    NuevaCuentaComponent,
    DatosCuentaComponent,
    MontoTransferenciaComponent,
    ConfirmacionTransferenciasComponent,
    ComprobanteComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    FormsModule,
    HttpClientModule,
    AuthModule,
 
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
