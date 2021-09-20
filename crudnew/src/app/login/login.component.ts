import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router, private loginservice: AuthenticationService) { }

  ngOnInit() {
   // document.body.className="selector1";
  }
 // ngOnDestroy(){
  //  document.body.className="";
 // }

  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['employees'])
      this.invalidLogin = false
     
    } else
      this.invalidLogin = true
      
  }

}