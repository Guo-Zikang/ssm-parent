package com.atguigu.boot;

import com.atguigu.boot.properties.DogProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(DogProperties.class)
@SpringBootApplication
public class Springboot01DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot01DemoApplication.class, args);
	}

}
