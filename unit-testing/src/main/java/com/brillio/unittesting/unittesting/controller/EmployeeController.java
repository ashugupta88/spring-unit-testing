package com.brillio.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.unittesting.unittesting.models.Employee;
import com.brillio.unittesting.unittesting.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/getName")
	public String getEmployee() {
		return "new Employee";
	}
	
	@GetMapping("/employee/getObject")
	public List<Employee> getEmployeeObject() {
		return employeeService.getEmployeeObject();
	}
	
}
