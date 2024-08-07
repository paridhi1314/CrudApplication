package com.springboot.springRest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.springRest.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constriuctor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		//create query 
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get result list 
		List<Employee> employees = theQuery.getResultList();
		
		
		//return the results 
		return employees;
	}

	@Override
	public Employee findById(int id) {
	
		//get the employee
		Employee theEmployee = entityManager.find(Employee.class, id);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//insert or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int id) {
		//get the employee
		Employee theEmployee = entityManager.find(Employee.class, id);
		//remove the employee
		
		entityManager.remove(theEmployee);
		
		
	}
	

}
