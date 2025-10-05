package com.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.main.entity.Employee;
import com.sp.main.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee createEmployee(Employee user) {
		
		return empRepo.save(user);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
				return  empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeDetails(long id) {
		// TODO Auto-generated method stub
		
				return empRepo.findById(id);
	}

	@Override
	public Employee updateEmployeeDetails(long id, Employee newEmp) {
		
		
		Employee empData=	empRepo.findById(id).orElse(null);
		if(empData!=null) {
			return empRepo.save(newEmp);
		}
		else {
			throw new RuntimeException("Employee not found with id:"+id);
		}
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
		empRepo.deleteById(id);
		
	}
	
	
}

