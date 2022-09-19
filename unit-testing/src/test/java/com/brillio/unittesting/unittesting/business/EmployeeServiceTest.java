package com.brillio.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.brillio.unittesting.unittesting.models.Employee;
import com.brillio.unittesting.unittesting.repo.EmployeeRepo;
import com.brillio.unittesting.unittesting.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeRepo employeeRepo;
	
	@Test
	public void getEmployeeObject() {
		when(employeeRepo.findAll()).thenReturn(Arrays.asList(new Employee(1, "Brillio")));
		List<Employee> list = employeeService.getEmployeeObject();	
		assertEquals("Brillio", list.get(0).getName());
	}
	

}
