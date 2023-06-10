import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-Verificar_Email',
  templateUrl: './Verificar_Email.component.html',
  styleUrls: ['./Verificar_Email.component.css']
})
export class Verificar_EmailComponent implements OnInit {
  code: any;
  entrycode: any;

  constructor(private router: Router,) { }

  ngOnInit() {
    this.code = localStorage.getItem('verification_code');
    
  }

  confirmarCodigo() {
    this.router.navigate(['/register/4'])
  }
}
