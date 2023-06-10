import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'Transaccion',
})
export class pipeTransaccion implements PipeTransform {
  transform(value: boolean): string {
    if (value) {
      return 'Enviada';
    } else {
      return 'Recibida';
    }
  }
}
