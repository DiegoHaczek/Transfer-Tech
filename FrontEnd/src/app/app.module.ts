//Angular Imports
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AuthModule } from './auth/auth.module';
import { InicioComponent } from './Components/inicio/inicio.component';
import { InterfazAdminComponent } from './Components/Admin/interfaz-admin/interfaz-admin.component';
import { HeaderComponent } from './Components/header/header.component';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';
import { FooterComponent } from './Components/footer/footer.component';
import { ClienteModule } from './Components/Cliente/cliente.module';
import { NgChartsModule } from 'ng2-charts';
// Data Visualization Library


// CLIENT COMPONENTS

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    HeaderComponent,
    FooterComponent,
    InterfazAdminComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    FormsModule,
    HttpClientModule,
    AuthModule,
    ClienteModule,
    NgChartsModule,

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
