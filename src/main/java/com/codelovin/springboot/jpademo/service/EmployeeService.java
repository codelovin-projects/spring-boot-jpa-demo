package com.codelovin.springboot.jpademo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codelovin.springboot.jpademo.entity.Employee;
import com.codelovin.springboot.jpademo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeService (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> retrieveAll() {
		return employeeRepository.findAll();
	}
	
	public List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName) {
		return employeeRepository.findByEmailAddressAndLastName(emailAddress, lastName);
	}
	
	public List<Employee> findDistinctPeopleByLastNameOrFirstName(String lastName, String firstName) {
		return employeeRepository.findDistinctPeopleByLastNameOrFirstName(lastName, firstName);
	}
	
	public List<Employee> findPeopleDistinctByLastNameOrFirstName(String lastName, String firstName) {
		return employeeRepository.findPeopleDistinctByLastNameOrFirstName(lastName, firstName);
	}
	
	public List<Employee> findByLastNameIgnoreCase(String lastName) {
		return employeeRepository.findByLastNameIgnoreCase(lastName);
	}
	
	public List<Employee> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName) {
		return employeeRepository.findByLastNameAndFirstNameAllIgnoreCase(lastName, firstName);
	}
	
	public List<Employee> findByLastNameOrderByFirstNameAsc(String lastName) {
		return employeeRepository.findByLastNameOrderByFirstNameAsc(lastName);
	}
	
	public List<Employee> findByLastNameOrderByFirstNameDesc(String lastName) {
		return employeeRepository.findByLastNameOrderByFirstNameDesc(lastName);
	}
}
