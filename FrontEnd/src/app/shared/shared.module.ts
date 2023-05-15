import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatChipsModule} from '@angular/material/chips';
import {MatButtonModule} from '@angular/material/button';
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatCheckboxModule,
    MatChipsModule,
    MatButtonModule
  ],
  exports:[MatToolbarModule, MatIconModule, MatCheckboxModule, MatChipsModule, MatButtonModule]
})
export class SharedModule { }
