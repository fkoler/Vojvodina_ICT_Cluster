package com.iktobuka.testing_project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iktobuka.testing_project.controllers.HomeController;

@SpringBootTest
public class AssertExampleTest {

	@Autowired
	protected HomeController homeController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}
}
