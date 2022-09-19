package com.brillio.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.brillio.unittesting.unittesting.models.Employee;
import com.brillio.unittesting.unittesting.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void getEmployeeName() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getName")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn();
		assertEquals("new Employee", result.getResponse().getContentAsString());
	}
	
	@Test
	public void getEmployeeObject() throws Exception {
		
		when(employeeService.getEmployeeObject()).thenReturn(Arrays.asList(new Employee(1, "Brillio")));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getObject")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn();
		
		JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Brillio\"}]", result.getResponse().getContentAsString(), false);
	}
}
