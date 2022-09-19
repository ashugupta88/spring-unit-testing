package com.brillio.unittesting.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class UnitTestingApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws JSONException {
		String result = this.restTemplate.getForObject("/employee/getObject", String.class);
		JSONAssert.assertEquals("[{id:1,name:Brillio}]", result, true);
	}

}
