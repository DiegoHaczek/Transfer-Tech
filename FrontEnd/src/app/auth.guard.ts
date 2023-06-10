import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard  implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const token = localStorage.getItem('token');

    if (token) {
      
      const payload = JSON.parse(atob(token.split('.')[1]));

      
      if (payload.roles === 'ROLE_USER') {
        return true; 
      }
    }0

    this.router.navigate(['/login']); 
    return false; 
  }
}
