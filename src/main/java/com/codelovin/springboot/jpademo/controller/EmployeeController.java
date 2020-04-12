package com.codelovin.springboot.jpademo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelovin.springboot.jpademo.entity.Employee;
import com.codelovin.springboot.jpademo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/api/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees() {
		// End-point: http://localhost:9099/api/employees
		List<Employee> employees = employeeService.retrieveAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/email-last-name")
	public ResponseEntity<List<Employee>> findByEmailAddressAndLastName(@RequestParam String email,
			@RequestParam String lastName) {
		// End-point:
		// http://localhost:9099/api/employees/email-last-name?email=ashok@example.com&lastName=Das
		List<Employee> employees = employeeService.findByEmailAddressAndLastName(email, lastName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/distinct-last-name-first-name")
	public ResponseEntity<List<Employee>> findDistinctPeopleByLastNameOrFirstName(@RequestParam String lastName,
			@RequestParam String firstName) {
		// End-point:
		// http://localhost:9099/api/employees/distinct-last-name-first-name?lastName=Reddy&firstName=Ashok
		List<Employee> employees = employeeService.findDistinctPeopleByLastNameOrFirstName(lastName, firstName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/last-name-first-name-distinct")
	public ResponseEntity<List<Employee>> findPeopleDistinctByLastNameOrFirstName(@RequestParam String lastName,
			@RequestParam String firstName) {
		// End-point:
		// http://localhost:9099/api/employees/last-name-first-name-distinct?lastName=Reddy&firstName=Ashok
		List<Employee> employees = employeeService.findPeopleDistinctByLastNameOrFirstName(lastName, firstName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/last-name-ignore-case")
	public ResponseEntity<List<Employee>> findByLastNameIgnoreCase(@RequestParam String lastName) {
		// End-point:
		// http://localhost:9099/api/employees/last-name-ignore-case?lastName=Reddy
		List<Employee> employees = employeeService.findByLastNameIgnoreCase(lastName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/last-name-first-name-ignore-case")
	public ResponseEntity<List<Employee>> findByLastNameAndFirstNameAllIgnoreCase(@RequestParam String lastName,
			@RequestParam String firstName) {
		// End-point:
		// http://localhost:9099/api/employees/last-name-first-name-ignore-case?lastName=Smith&firstName=Michael
		List<Employee> employees = employeeService.findByLastNameAndFirstNameAllIgnoreCase(lastName, firstName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/last-name-order-by-first-name-asc")
	public ResponseEntity<List<Employee>> findByLastNameOrderByFirstNameAsc(@RequestParam String lastName) {
		// End-point:
		// http://localhost:9099/api/employees/last-name-order-by-first-name-asc?lastName=Smith
		List<Employee> employees = employeeService.findByLastNameOrderByFirstNameAsc(lastName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/api/employees/last-name-order-by-first-name-desc")
	public ResponseEntity<List<Employee>> findByLastNameOrderByFirstNameDesc(@RequestParam String lastName) {
		// End-point:
		// http://localhost:9099/api/employees/last-name-order-by-first-name-desc?lastName=Smith
		List<Employee> employees = employeeService.findByLastNameOrderByFirstNameDesc(lastName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
