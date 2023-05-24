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
import { AuthModule } from './auth/auth.module';
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

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    FormsModule,
    HttpClientModule,
    AuthModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
