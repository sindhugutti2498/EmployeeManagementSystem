package com.example.springboot.springbootjpacrud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot.springbootjpacrud.exception.ResourceNotFoundException;
import com.example.springboot.springbootjpacrud.model.Employee;
import com.example.springboot.springbootjpacrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	   public List<Employee> getAllEmployees() {
	       // return employeeRepository.findAll();
		   List<Employee> emp=employeeRepository.findAll();
		 //  System.out .println("getting data from DB"+emp);
		   return emp;
	    }

	  public ResponseEntity<Employee> getEmployeeById(Long employeeId)throws ResourceNotFoundException
	    {
		  
	        Employee employee = employeeRepository.findById(employeeId)
	         .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	       System.out.println("employee found"+employee.getFirstName());
	        return ResponseEntity.ok().body(employee);
	    }
	    
	     public Employee createEmployee(Employee employee) {
	    	 System.out.println("added user "+employee);
	        return employeeRepository.save(employee);
	    }

	    public ResponseEntity<Employee> updateEmployee(Long employeeId,Employee employeeDetails) 
	    		throws ResourceNotFoundException{
	        Employee employee = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        employee.setEmailId(employeeDetails.getEmailId());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setFirstName(employeeDetails.getFirstName());
	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	 public Map<String, Boolean> deleteEmployee(Long employeeId)
	         throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        employeeRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    public void  deleteEmp(Employee e) {
	        System.out.println("deleted user");
	    	employeeRepository.delete(e);
	    }
}
