package com.example.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com/example/Spring/CrudOperationOnAnEntity/controller"})// this is to scan the controller package when the application starts
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);}
}
