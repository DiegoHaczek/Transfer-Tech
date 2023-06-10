import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { Frente_DNIComponent } from './register/Frente_DNI/Frente_DNI.component';
import { Verificar_TelefonoComponent } from './register/Verificar_Telefono/Verificar_Telefono.component';
import { Creacion_CuentaComponent } from './register/Creacion_Cuenta/Creacion_Cuenta.component';
import { Primer_EmailComponent } from './register/Primer_Email/Primer_Email.component';
import { Verificar_EmailComponent } from './register/Verificar_Email/Verificar_Email.component';
import { Datos_PersonalesComponent } from './register/Datos_Personales/Datos_Personales.component';
import { Dorso_DNIComponent } from './register/Dorso_DNI/Dorso_DNI.component';
import { Selfie_DNIComponent } from './register/Selfie_DNI/Selfie_DNI.component';
import { Verificar_Telefono_P2Component } from './register/Verificar_Telefono_P2/Verificar_Telefono_P2.component';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    Frente_DNIComponent,
    Verificar_TelefonoComponent,
    Creacion_CuentaComponent,
    Primer_EmailComponent,
    Verificar_EmailComponent,
    Datos_PersonalesComponent,
    Dorso_DNIComponent,
    Selfie_DNIComponent,
    Verificar_Telefono_P2Component,
   
  ],
  imports: [CommonModule, SharedModule, ReactiveFormsModule, FormsModule],
})
export class AuthModule {}
