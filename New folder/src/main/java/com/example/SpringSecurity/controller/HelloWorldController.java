package com.example.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.controller.service.DatabaseService;

@RestController
public class HelloWorldController {

	@Autowired
	private DatabaseService dataBaseService;

	@GetMapping("/helloworld")
	public String getHelloWorldMessage() {
		System.out.println("hi---3");
		return "hello world";
	}

	@GetMapping("/profile")
	public Boolean getProfile() {

		return dataBaseService.performDatabaseOperation();
	}

}
