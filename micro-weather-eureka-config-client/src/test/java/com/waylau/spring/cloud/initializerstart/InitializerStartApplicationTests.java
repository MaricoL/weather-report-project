package com.waylau.spring.cloud.initializerstart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitializerStartApplicationTests {

	@Value("${author}")
	private String username;

	@Test
	public void contextLoads() {
		System.out.println(username);
	}

}
