import { Component, OnChanges, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-Creacion_Cuenta',
  templateUrl: './Creacion_Cuenta.component.html',
  styleUrls: ['./Creacion_Cuenta.component.css']
})
export class Creacion_CuentaComponent  {
  toppings = this._formBuilder.group({
    check: false,

   
  });
  disabledButton = true;

  constructor(private _formBuilder: FormBuilder, private router: Router) {}
  ngOnInit() {
    this.toppings.valueChanges.subscribe((value) => {
      this.disabledButton = !value.check;
    });
  }
  siguiente(){
this.router.navigate(['/register/2']) 
  }
}
