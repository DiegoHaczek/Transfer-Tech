import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { Creacion_CuentaComponent } from './auth/register/Creacion_Cuenta/Creacion_Cuenta.component';
import { Primer_EmailComponent } from './auth/register/Primer_Email/Primer_Email.component';
import { Verificar_EmailComponent } from './auth/register/Verificar_Email/Verificar_Email.component';
import { Frente_DNIComponent } from './auth/register/Frente_DNI/Frente_DNI.component';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';
import { Datos_PersonalesComponent } from './auth/register/Datos_Personales/Datos_Personales.component';
import { Dorso_DNIComponent } from './auth/register/Dorso_DNI/Dorso_DNI.component';
import { AuthGuard } from './auth.guard';
import { Selfie_DNIComponent } from './auth/register/Selfie_DNI/Selfie_DNI.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  { path: 'login', component: LoginComponent },
  { path: 'register/1', component: Creacion_CuentaComponent },
  { path: 'register/2', component: Primer_EmailComponent },
  { path: 'register/3', component: Verificar_EmailComponent },
  { path: 'register/4', component: Datos_PersonalesComponent },
  { path: 'register/5', component: Frente_DNIComponent },
  { path: 'register/6', component: Dorso_DNIComponent },
  { path: 'register/7', component: Selfie_DNIComponent },

  
  {
    path: 'cliente', canActivate: [AuthGuard],
    loadChildren: () =>
      import('./Components/Cliente/cliente.module').then(
        (m) => m.ClienteModule
      ),
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
