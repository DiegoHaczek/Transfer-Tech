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
import { PrincipalComponent } from './Components/Cliente/Perfil/principal/principal.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forgot', component: ForgotPasswordComponent },
  {
    path: 'cliente',
    loadChildren: () =>
      import('./Components/Cliente/cliente.module').then(
        (m) => m.ClienteModule
      ),
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
  {
    path: 'perfil/1',
    component: PrincipalComponent,
  },
  {
    path: 'perfil/2',
    component: ComprobanteComponent,
  },
  {
    path: 'perfil/3',
    component: ComprobanteComponent,
  },
  {
    path: 'perfil/4',
    component: ComprobanteComponent,
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
