import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ITransfer } from '../models/itransfer';
import { Observable } from 'rxjs';
import { Iprofile } from '../models/Iprofile';

@Injectable({
  providedIn: 'root',
})
export class ClientsService {
  apiUrl = 'https://transfertech.site/api/v1';
  accountEndpoint = '/account';
  userEndpoint = '/user';

  constructor(private http: HttpClient) {}

  getClientId(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}${this.accountEndpoint}/${id} `);
  }
  getClientCVU(CVU: string): Observable<any> {
    const requestBody = { account_number: CVU };
    return this.http.post<any>(
      `${this.apiUrl}${this.accountEndpoint}/info/account_number `,
      requestBody
    );
  }
  getClientAlias(alias: string): Observable<any> {
    const requestBody = { alias: alias };
    return this.http.post<any>(
      `${this.apiUrl}${this.accountEndpoint}/info/alias `,
      requestBody
    );
  }

  getTransfers(id: number): Observable<ITransfer[]> {
    return this.http.get<ITransfer[]>(
      `${this.apiUrl}${this.accountEndpoint}/${id}/movements`
    );
  }
  getId(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}${this.userEndpoint}/${id} `);
  }
  tranferir(id: number, transfer: ITransfer): Observable<any> {
    return this.http.post<any>(
      `${this.apiUrl}${this.accountEndpoint}/${id}/transfer`,
      transfer
    );
  }
  depositar(id: number, amount: number): Observable<any> {
    const requestBody = { amount: amount };
    return this.http.post<any>(
      `${this.apiUrl}${this.accountEndpoint}/${id}/deposit `,
      requestBody
    );
  }
  createPerfil(id: number, datos: Iprofile): Observable<any> {
   
    return this.http.post<any>(
      `${this.apiUrl}${this.userEndpoint}/${id}/profile `,
      datos
    );
  }

}
