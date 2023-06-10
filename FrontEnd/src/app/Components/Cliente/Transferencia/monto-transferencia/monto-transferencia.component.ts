import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ClientsService } from 'src/app/Service/clients.service';
import { DataTransportService } from 'src/app/Service/data-transport.service';
import { IClient } from 'src/app/models/IClient';

@Component({
  selector: 'app-monto-transferencia',
  templateUrl: './monto-transferencia.component.html',
  styleUrls: ['./monto-transferencia.component.css'],
})
export class MontoTransferenciaComponent {
  id: string = '';
  idReceptor: string = '';

  client: IClient = {
    id: 0,
    userName: '',
    balance: 0,
    accountNumber: 0,
    active: true,
    alias: '',
    qr: '',
    cardActive: true,
  cardCvv:0,
  cardExpiration:'',
  cardIssuance: '',
  cardNumber: '',
  };
  transfer = {
    receiverAccountId: '1',
    description: '.',
    amount: 0,
  };

  constructor(
    private clientService: ClientsService,
    private transport: DataTransportService,
    private router: Router,
    private fb: FormBuilder
  ) {}
  valor = new FormControl(null, [
    Validators.required,
    Validators.max(this.client.balance),
  ]);
  Categoria = new FormControl(null, [Validators.required]);
  ngOnInit() {
    this.id = this.transport.obtenerDato('id');
    this.idReceptor = this.transport.obtenerDato('idReceptor');
    this.clientService.getClientId(Number(this.id)).subscribe((client) => {
      this.client = client;
      this.valor.setValidators([
        Validators.required,
        Validators.max(this.client.balance),
      ]);
      this.valor.updateValueAndValidity();
    });
  }

  guardarTransferencia() {
    this.transfer = {
      receiverAccountId: this.idReceptor,
      description: this.Categoria.value !== null ? this.Categoria.value : '',
      amount: this.valor.value !== null ? this.valor.value : 0,
    };
    this.transport.guardarDato('transfer', JSON.stringify(this.transfer));

    this.router.navigate(['/cliente/transfer/5']);
  }
}
