import { NgModule } from '@angular/core';


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatChipsModule} from '@angular/material/chips';
import {MatButtonModule} from '@angular/material/button';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';

@NgModule({
  declarations: [],
  imports: [
  
    MatToolbarModule,
    MatIconModule,
    MatCheckboxModule,
    MatChipsModule,
    MatButtonModule,
    MatSlideToggleModule,
    MatCardModule,
    MatDividerModule
  ],
  exports:[MatToolbarModule, MatIconModule, MatCheckboxModule, MatChipsModule, MatButtonModule, MatSlideToggleModule, MatCardModule, MatDividerModule]
})
export class SharedModule { }
