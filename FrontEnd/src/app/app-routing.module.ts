import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ForgotPasswordComponent } from './auth/forgot-password/forgot-password.component';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';
import { TransferenciasComponent } from './Components/Cliente/Transferencia/transferencias/transferencias.component';
import { NuevaCuentaComponent } from './Components/Cliente/Transferencia/nueva-cuenta/nueva-cuenta.component';
import { DatosCuentaComponent } from './Components/Cliente/Transferencia/datos-cuenta/datos-cuenta.component';
import { MontoTransferenciaComponent } from './Components/Cliente/Transferencia/monto-transferencia/monto-transferencia.component';
import { ConfirmacionTransferenciasComponent } from './Components/Cliente/Transferencia/confirmacion-transferencias/confirmacion-transferencias.component';
import { ComprobanteComponent } from './Components/Cliente/Transferencia/comprobante/comprobante.component';
import { ClientDashboardComponent } from './Components/Cliente/client-dashboard/client-dashboard.component';
import { Frente_DNIComponent } from './auth/register/Frente_DNI/Frente_DNI.component';
import { Verificar_TelefonoComponent } from './auth/register/Verificar_Telefono/Verificar_Telefono.component';
import { Creacion_CuentaComponent } from './auth/register/Creacion_Cuenta/Creacion_Cuenta.component';
import { Primer_EmailComponent } from './auth/register/Primer_Email/Primer_Email.component';
import { Verificar_EmailComponent } from './auth/register/Verificar_Email/Verificar_Email.component';
import { Datos_PersonalesComponent } from './auth/register/Datos_Personales/Datos_Personales.component';
import { Dorso_DNIComponent } from './auth/register/Dorso_DNI/Dorso_DNI.component';
import { Selfie_DNIComponent } from './auth/register/Selfie_DNI/Selfie_DNI.component';
import { Verificar_Telefono_P2Component } from './auth/register/Verificar_Telefono_P2/Verificar_Telefono_P2.component';



const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component:Verificar_Telefono_P2Component},
  { path: 'forgot', component: ForgotPasswordComponent },
  {
    path: 'cliente',
    loadChildren: () =>
      import('./Components/Cliente/cliente.module').then(
        (m) => m.ClienteModule
      ),
  },
  {
    path: 'dash',
    component: ClientDashboardComponent,
  },
  {
    path: '**',
    component: PageNotFoundComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
