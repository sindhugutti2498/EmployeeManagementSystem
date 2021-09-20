import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuardService } from './service/auth-guard.service';
import { HomeComponent } from './home/home.component';
//import { EmploginComponent } from './emplogin/emplogin.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent,canActivate:[AuthGuardService] },
  { path: 'add', component: CreateEmployeeComponent,canActivate:[AuthGuardService] },
  { path: 'update/:id', component: UpdateEmployeeComponent,canActivate:[AuthGuardService] },
  { path: 'details/:id', component: EmployeeDetailsComponent,canActivate:[AuthGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGuardService] },
  {path: 'home',component:HomeComponent}  
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }