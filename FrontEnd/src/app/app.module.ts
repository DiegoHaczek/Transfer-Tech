//Angular Imports
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

import { HeaderComponent } from './Components/header/header.component';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';
import { ClienteModule } from './Components/Cliente/cliente.module';
import { NgChartsModule } from 'ng2-charts';
import { DataTransportService } from './Service/data-transport.service';
import { AuthModule } from './auth/auth.module';

@NgModule({
  declarations: [AppComponent, HeaderComponent, PageNotFoundComponent],
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
  providers: [DataTransportService],
  bootstrap: [AppComponent],
})
export class AppModule {}
