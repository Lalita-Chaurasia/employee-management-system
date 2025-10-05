package com.sp.main.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sp.main.entity.Employee;
import com.sp.main.services.EmployeeService;



@RestController
public class MyController {
	
	@Autowired
	private EmployeeService empSer;
	
	
	@PostMapping("/employee")
	public Employee addUserDetails(@RequestBody Employee emp) {
		
		return empSer.createEmployee(emp);

	}
	@GetMapping("/employee")
	public List<Employee> getAllUserDetail(){
		return empSer.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getUserDetails(@PathVariable int id){
		Employee emp=empSer.getEmployeeDetails(id).orElse(null);
		if(emp!=null) {
			return ResponseEntity.ok().body(emp);
		}
		else {
 			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateUserDetails(@PathVariable long id,@RequestBody Employee emp) {
	Employee updatedEmp=	empSer.updateEmployeeDetails(id, emp);
	if(updatedEmp!=null) {
		return ResponseEntity.ok(updatedEmp);
	}
	else {
		return ResponseEntity.notFound().build();
	}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable long id){
		empSer.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

}
