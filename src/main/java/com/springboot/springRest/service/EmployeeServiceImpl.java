package com.springboot.springRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.springRest.dao.EmployeeRepository;
import com.springboot.springRest.entities.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//	private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeeRepository.findById(id);
//		return employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {

		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int Id) {
		employeeRepository.deleteById(Id);

	}

}
