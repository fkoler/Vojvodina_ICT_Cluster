package com.iktobuka.testing_project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	protected Integer port;
	
	@Autowired
	protected TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws	Exception {
	assertThat(this.restTemplate.getForObject(
			"http://localhost:" + port + "/", String.class)
		).contains("Hello World");
	}
}
