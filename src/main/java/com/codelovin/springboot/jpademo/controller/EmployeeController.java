package com.codelovin.springboot.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelovin.springboot.jpademo.entity.Employee;
import com.codelovin.springboot.jpademo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.retrieveAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
