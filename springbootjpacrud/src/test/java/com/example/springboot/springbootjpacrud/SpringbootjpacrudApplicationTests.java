package com.example.springboot.springbootjpacrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springboot.springbootjpacrud.model.Employee;
import com.example.springboot.springbootjpacrud.repository.EmployeeRepository;
import com.example.springboot.springbootjpacrud.service.EmployeeService;

@SpringBootTest
class SpringbootjpacrudApplicationTests {

	@Autowired
	private EmployeeService service;
		
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void getAllEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee("suj","gut","sujg@gm.cm"),new Employee("vnk","shv","vnkshv@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,service.getAllEmployees().size());
	}
	@Test
	public void createEmployeeTest() {
		Employee emp=new Employee("bts","jin","btsjn@gm.cm");
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp,service.createEmployee(emp));
	}
	@Test
	public void getEmployeeByIdTest()
	{
		String empemail="sin@gm.cm";
		//ResponseEntity<Employee> e=service.getEmployeeById((long) 24);
		Employee emp = new Employee("sin","dhu","sin@gm.cm") ;      
	     Mockito.when(repository.findById(0)).thenReturn(emp);
		assertEquals(empemail,emp.getEmailId());
	}
	@Test
	public void deleteEmpTest() {
		Employee e=new Employee("kim","taehyung","v@gm.cm");
	   service.deleteEmp(e);
	   verify(repository,times(1)).delete(e);
	}
	/*@Test
	public void getEmployeeByIdTest() {
		long id=24;
		when(repository.findById(id)).thenReturn(Stream
				.of(new Employee("sin","dhu","sg@gmail.com")).collect(Collectors.toList()));
		assertEquals("sin",service.getEmployeeById(id).size());
	}*/
	/* @Test
	 * public void getEmployeeByIdTest() {
	 * final long id=1L;
	 * final Employee emp=new Employee("sin","dhu","sng@gm.cm");
	 * given(repository).save(emp)).willReturn(emp);
	 *verify(repository).save(any(Employee.class));
	 
	
	/*@Test
	public void deleteEmployeeTest() {
		Employee emp=new Employee("bts","jin","btsjn@gm.cm");
		service.deleteEmployee(emp);
	}*/
}
