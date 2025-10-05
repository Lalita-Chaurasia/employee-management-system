package com.sp.main.services;

import java.util.List;
import java.util.Optional;

import com.sp.main.entity.Employee;

public interface EmployeeService {

	
	public Employee createEmployee(Employee emp); 
	public List<Employee> getAllEmployee();
	public Optional<Employee> getEmployeeDetails(long id);
	public Employee updateEmployeeDetails(long id, Employee emp);
	public void deleteEmployee(long id);
	
}
