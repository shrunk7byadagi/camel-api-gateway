package com.tiaa.platformone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiaa.platformone.model.Customer;

@RestController
public class PlatformController {

	@GetMapping("/customer")
	public Customer HelloWorld(){
		Customer c = new Customer();
		c.setName("Shreyank");
		c.setLastName("Byadagi");
		return c;
	}
}
