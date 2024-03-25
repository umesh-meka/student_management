package com.demo.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoSpringbootRestApplication {

	public static void main(String[] args) {
		// one way to run the application
		//SpringApplication.run(DemoSpringbootRestApplication.class, args);
		
		// other way to run the application
		// by giving the customized context path
		System.setProperty("server.servlet.context-path", "/app");
		SpringApplication.run(DemoSpringbootRestApplication.class, args);
	}

}

@RestController
class SimpleRestAPI {
	
	@GetMapping("/")
	public String message() {
		return "Welcome to sample message" +
				" \nwe have lot to implement";
	}
}
