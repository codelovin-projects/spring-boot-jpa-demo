package com.codelovin.springboot.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelovin.springboot.jpademo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);

	// Enables the distinct flag for the query
	List<Employee> findDistinctPeopleByLastNameOrFirstName(String lastName, String firstName);
	List<Employee> findPeopleDistinctByLastNameOrFirstName(String lastName, String firstName);

	// Enabling ignoring case for an individual property
	List<Employee> findByLastNameIgnoreCase(String lastName);

	// Enabling ignoring case for all suitable properties
	List<Employee> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName);

	// Enabling static ORDER BY for a query
	List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

	List<Employee> findByLastNameOrderByFirstNameDesc(String lastName);
}
