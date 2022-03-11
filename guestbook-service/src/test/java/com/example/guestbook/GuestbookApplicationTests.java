package com.example.guestbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * The @SpringBootTest annotation tells Spring Boot to look for a main configuration class
 * (one with @SpringBootApplication, for instance) and use that to start a Spring application context.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestbookApplicationTests {

	@Test
	public void contextLoads() {
	}
}
