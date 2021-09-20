package com.example.springboot.springbootjpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.springbootjpacrud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Employee findById(long id);

}