package com.atguigu.boot;

import com.atguigu.boot.properties.DogProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01DemoApplicationTests {

	@Autowired
	DogProperties dogProperties;

	@Test
	void contextLoads() {
		System.out.println("dogProperties = " + dogProperties);
	}

}
