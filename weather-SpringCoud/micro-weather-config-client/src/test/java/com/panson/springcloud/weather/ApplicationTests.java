package com.panson.springcloud.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Value("${author}")
	private String author;

	@Test
	public void contextLoads() {
		assertEquals("panson.top",author);
	}

}
