package com.springboot.springRest.dao;

import java.util.List;

import com.springboot.springRest.entities.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	
	Employee findById(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int Id);
}
