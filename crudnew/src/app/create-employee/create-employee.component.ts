import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup,FormControl,Validators } from '@angular/forms';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

 /* employee: Employee = new Employee();
  submitted = false;
  constructor(private employeeService: EmployeeService,
    private router: Router) { }
  ngOnInit() {}
  
  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
    console.log(data),
     this.employee = new Employee();
     // this.gotoList();
      this.router.navigate(['/employees']);
      alert("user added successfully");
    }, 
    error => console.log(error));
  }
  onSubmit() {
   this.submitted = true;
    this.save();    
  }
  //gotoList() {
    //this.router.navigate(['/employees']);
  //}
}*/
employee:Employee = new Employee();
submitted = false;

constructor(private employeeService: EmployeeService,private router: Router) {}
ngOnInit() {}

onSubmit() {
  this.submitted = true;
    this.save(); 
}
save() {
  this.employeeService
  .createEmployee(this.employee).subscribe(data => {
  console.log(data),
   this.employee = new Employee();
   // this.gotoList();
    this.router.navigate(['/employees']);
    alert("user added successfully");
  }, 
  error => console.log(error));
}
}

  