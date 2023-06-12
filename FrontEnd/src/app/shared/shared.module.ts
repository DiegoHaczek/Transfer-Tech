import { NgModule } from '@angular/core';
//Material
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatBadgeModule } from '@angular/material/badge';
import { MatMenuModule } from '@angular/material/menu';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';





const shared = [
  MatToolbarModule,
  MatIconModule,
  MatCheckboxModule,
  MatChipsModule,
  MatButtonModule,
  MatSlideToggleModule,
  MatCardModule,
  MatDividerModule,
  MatTableModule,
  MatFormFieldModule,
  MatPaginatorModule,
  MatSortModule,
  MatBadgeModule,
  MatMenuModule,
  MatInputModule,
  MatDialogModule,
  MatTabsModule,
  MatSelectModule,
  MatSnackBarModule,
  MatProgressSpinnerModule

  
];
@NgModule({
  declarations: [],
  imports: shared,
  exports: shared,
})
export class SharedModule {}
