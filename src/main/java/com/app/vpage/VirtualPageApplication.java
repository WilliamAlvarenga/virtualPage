package com.app.vpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class VirtualPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualPageApplication.class, args);
	}

	
}
