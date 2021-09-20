import { Component } from '@angular/core';
import { Router,NavigationStart} from '@angular/router';
import { AuthenticationService } from './service/authentication.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Employee Management System'; 
  showHead:boolean=false;
  constructor(private router: Router,public loginService:AuthenticationService) {
        router.events.forEach((event) => {
        if (event instanceof NavigationStart) {
        // if (event['url'] == '/login' || event['url']== '/add' || event['url']== '/employees'){
         if (event['url'] == '/login') {
            this.showHead = false;
          } else {
            this.showHead = true;
          }
        }
      });
    }

}


