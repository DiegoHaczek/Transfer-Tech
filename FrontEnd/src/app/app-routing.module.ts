import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './Components/inicio/inicio.component';

const routes: Routes = [{
  path: '', redirectTo:'home' ,pathMatch: 'full' 
  
  
},{
  path: 'home', component: InicioComponent
},
// {
//   path: '**', component: 
// }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
