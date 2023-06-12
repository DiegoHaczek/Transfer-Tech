import { Injectable } from '@angular/core';
import { Observable, Subject, shareReplay, tap } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import jwtDecode from 'jwt-decode';
import { TagContentType } from '@angular/compiler';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  Auth: string = 'authenticate';
  Register: string = 'register';
  apiUrl: string = 'https://transfertech.site/api/v1/auth/';
  private loginStatusSubject: Subject<boolean> = new Subject<boolean>();
  loginStatus$ = this.loginStatusSubject.asObservable();
  
  constructor(private http: HttpClient, private router:Router) {}
  
 
  
  login(email: string, password: string): Observable<{ token: string }> {
    const body = { email: email, password: password };
    this.loginStatusSubject.next(true);
    return this.http
      .post<{ token: string }>(this.apiUrl + this.Auth, body)
      .pipe(
        tap(({ token }) => this.saveTokenToLocalStorage(token)),
        shareReplay()
      );
  }
  logouth() {
    localStorage.clear();
    this.loginStatusSubject.next(false);
    this.router.navigate(['/login']);
  }
  register(email: string, password: string) {
    const requestData = {
      email: email,
      password: password,
    };

    return this.http.post<any>(this.apiUrl + this.Register, requestData);
  }

  private saveTokenToLocalStorage(token: string): void {
    localStorage.setItem('token', token);
    const decodedToken: any = jwtDecode(token);
    const id = decodedToken.id;
    localStorage.setItem('id', id);
  }
  approvalRegister(id:number, files: File[]): Observable<any> {
    
    const formData = new FormData();
    formData.append('selfie_photo', files[2]);
    formData.append('identity_card_front', files[0]);
    formData.append('identity_card_back', files[1]);
    
   
    return this.http.post(`${this.apiUrl}${id}/approval_request `, formData);
  }
  
}
