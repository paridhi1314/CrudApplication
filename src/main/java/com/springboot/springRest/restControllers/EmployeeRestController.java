package com.springboot.springRest.restControllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springRest.dao.EmployeeDAO;
import com.springboot.springRest.entities.Employee;
import com.springboot.springRest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
//	private EmployeeDAO employeeDAO;
	private EmployeeService employeeService;
	
	//expose "/employees" and return the list of employees
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	//add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		
		return theEmployee;
	}
	
	//add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//also just in case they pass an id in JSON ... set id to 0
		//this is to force a save of new item ...  instead of update
		
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
		
	}
	
	//update mapping for PUT /employees - update existing employees
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	
	//delete mapping - for DELETE /employees/{employeeId} - delete the employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		
		//throw an exception
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found -- " + employeeId);
			
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee id " + employeeId;
	}
	
	

}
