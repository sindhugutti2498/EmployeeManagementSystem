package com.example.springboot.springbootjpacrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.springbootjpacrud.exception.ResourceNotFoundException;
import com.example.springboot.springbootjpacrud.model.Employee;
import com.example.springboot.springbootjpacrud.repository.EmployeeRepository;
import com.example.springboot.springbootjpacrud.service.EmployeeService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {
	
    @Autowired
    private EmployeeService service;
    
     @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
         return service.getEmployeeById(employeeId);
  
    }
  
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) 
        throws ResourceNotFoundException {
               return  service.updateEmployee(employeeId, employeeDetails);
    }

    @DeleteMapping("/employees/{id}")
   public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
            return  service.deleteEmployee(employeeId);
    }
         /*  public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") String employeeId) {
        String response = service.deleteEmployee(employeeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
    @DeleteMapping("/employees")
    public void deleteEmp(@Valid @RequestBody Employee employee) {
    	 service.deleteEmp(employee);
    }
}
