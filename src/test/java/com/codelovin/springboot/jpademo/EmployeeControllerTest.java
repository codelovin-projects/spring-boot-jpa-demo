package com.codelovin.springboot.jpademo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.codelovin.springboot.jpademo.controller.EmployeeController;
import com.codelovin.springboot.jpademo.entity.Employee;
import com.codelovin.springboot.jpademo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EmployeeService employeeService;

	@Test
	void verifyGetAllEndpoint() throws Exception {
		mockMvc.perform(get("/api/employees")).andExpect(status().isOk());
	}

	@Test
	void verifyPostEndpoint() throws Exception {
		Employee emp = new Employee("firstName", "lastName", "employeeCode",
				"example@example.com", "city", "country");
		
		mockMvc.perform(post("/api/employees")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(emp)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void verifyInputValidation() throws Exception {
		//Since we are passing NULL employee code, the controller should return
		//with Bad Request status, for @NotNull input validation is in place
		Employee emp = new Employee("firstName", "lastName", null,
				"example@example.com", "city", "country");
		
		mockMvc.perform(post("/api/employees")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(emp)))
		        .andExpect(status().isBadRequest());
	}
	
	@Test
	void verifyServiceCall() throws Exception {
		Employee emp = new Employee("firstName", "lastName", "employeeCode",
				"example@example.com", "city", "country");
		
		mockMvc.perform(post("/api/employees")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(emp)))
		        .andExpect(status().isOk());
		
		//Here service method accept object of Employee class.
		ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
		
		//verify call checks that saveEmployee() method has been called exactly once.
		verify(employeeService, times(1)).saveEmployee(employeeCaptor.capture());
		assertThat(employeeCaptor.getValue().getFirstName()).isEqualTo("firstName");
		assertThat(employeeCaptor.getValue().getEmailAddress()).isEqualTo("example@example.com");
	}
}
