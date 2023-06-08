import { Injectable } from '@angular/core';
import { Observable, shareReplay, tap } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  apiUrl: string = 'http://100.24.32.13/api/v1/auth/authenticate';
  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<{ token: string }> {
    const body = { email, password };
    return this.http.post<{ token: string }>(this.apiUrl, body).pipe(
      tap(({ token }) => this.saveTokenToLocalStorage(token)),
      shareReplay()
    );
  }

  private saveTokenToLocalStorage(token: string): void {
    localStorage.setItem('token', token);
  }
}
