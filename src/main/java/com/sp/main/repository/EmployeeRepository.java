package com.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
