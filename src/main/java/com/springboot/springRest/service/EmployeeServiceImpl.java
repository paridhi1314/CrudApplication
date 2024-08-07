package com.springboot.springRest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springRest.dao.EmployeeDAO;
import com.springboot.springRest.entities.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}


	@Override
	public List<Employee> findAll() {
	
		return employeeDAO.findAll();
	}


	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}


	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		
		return employeeDAO.save(theEmployee);
	}


	@Override
	@Transactional
	public void deleteById(int Id) {
	employeeDAO.deleteById(Id);
		
	}
	
}
