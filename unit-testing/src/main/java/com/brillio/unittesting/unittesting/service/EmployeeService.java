package com.brillio.unittesting.unittesting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.unittesting.unittesting.models.Employee;
import com.brillio.unittesting.unittesting.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployeeObject() {
		List<Employee> list = employeeRepo.findAll();
		return list.stream().filter(employee -> employee.getName()
				.equals("Brillio")).collect(Collectors.toList());
	}
	
}
