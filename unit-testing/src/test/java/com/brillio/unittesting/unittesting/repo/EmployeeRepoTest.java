package com.brillio.unittesting.unittesting.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.brillio.unittesting.unittesting.models.Employee;

@DataJpaTest
class EmployeeRepoTest {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	public void testFindAll() {
		List<Employee> list = employeeRepo.findAll();
		assertEquals(5, list.size());
	}

}
