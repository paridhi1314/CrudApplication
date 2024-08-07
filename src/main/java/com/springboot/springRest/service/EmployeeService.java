package com.springboot.springRest.service;

import java.util.List;

import com.springboot.springRest.entities.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee theEmployee);

	void deleteById(int Id);

}
