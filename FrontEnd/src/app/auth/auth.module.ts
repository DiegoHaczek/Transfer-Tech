import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { Frente_DNIComponent } from './register/Frente_DNI/Frente_DNI.component';
import { Creacion_CuentaComponent } from './register/Creacion_Cuenta/Creacion_Cuenta.component';
import { Primer_EmailComponent } from './register/Primer_Email/Primer_Email.component';
import { Verificar_EmailComponent } from './register/Verificar_Email/Verificar_Email.component';
import { Datos_PersonalesComponent } from './register/Datos_Personales/Datos_Personales.component';
import { Dorso_DNIComponent } from './register/Dorso_DNI/Dorso_DNI.component';
import { Selfie_DNIComponent } from './register/Selfie_DNI/Selfie_DNI.component';



@NgModule({
  declarations: [
    LoginComponent,
    Frente_DNIComponent,
    
    Creacion_CuentaComponent,
    Primer_EmailComponent,
    Verificar_EmailComponent,
    Datos_PersonalesComponent,
    Dorso_DNIComponent,
    Selfie_DNIComponent,
    
   
  ],
  imports: [CommonModule, SharedModule, ReactiveFormsModule, FormsModule],
})
export class AuthModule {}
