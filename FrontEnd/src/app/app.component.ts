import { Component, OnInit } from '@angular/core';
import { AuthService } from './Service/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TransferTech';
  login: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.loginStatus$.subscribe((status) => {
      this.login = status;
    });
  }
}