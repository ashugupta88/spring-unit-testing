package com.brillio.unittesting.unittesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brillio.unittesting.unittesting.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
