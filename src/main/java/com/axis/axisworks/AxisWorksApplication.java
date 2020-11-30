package com.axis.axisworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AxisWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxisWorksApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHi() {
		System.out.println("Invoked application Axis-App"); 
		return "Hello World from Axis Bank on 30-Nov, building with jenkins"; 
	}	

	@GetMapping("/hello1")
	public String sayHi1() {
		System.out.println("Invoked application Axis-App"); 
		return "Hello World from Axis Bank on 30-Nov"; 
	}

	@PostMapping("/hello")
	public String postHello() {
		System.out.println("Invoked application Axis-App"); 
		return "Hello World from Axis Bank on 30-Nov"; 
	}


}
