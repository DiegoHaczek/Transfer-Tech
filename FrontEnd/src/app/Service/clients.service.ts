import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ITransfer } from '../models/itransfer';
import { Observable } from 'rxjs';
import { IClient } from '../models/iclient';

@Injectable({
  providedIn: 'root',
})
export class ClientsService {
  apiUrl = 'http://localhost:3000/api/v1';
  transfEndpoint = '/transferencias';
  clientEndpoint = '/clients';
  constructor(private http: HttpClient) {}

  getClient(): Observable<IClient> {
    return this.http.get<IClient>(`${this.apiUrl}${this.clientEndpoint}`);
  }

  getTransfers(): Observable<ITransfer[]> {
    return this.http.get<ITransfer[]>(`${this.apiUrl}${this.transfEndpoint}`);
  }
}
