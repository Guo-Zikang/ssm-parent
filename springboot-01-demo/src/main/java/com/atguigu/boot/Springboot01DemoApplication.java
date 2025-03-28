package com.atguigu.boot;

import com.atguigu.boot.properties.DogProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigurationProperties(DogProperties.class)
@SpringBootApplication
public class Springboot01DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Springboot01DemoApplication.class, args);

//		SpringApplicationBuilder builder = new SpringApplicationBuilder();
//		builder.sources(Springboot01DemoApplication.class)
//				.bannerMode(Banner.Mode.CONSOLE)
//				.run(args);

		SpringApplication application = new SpringApplication(Springboot01DemoApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
