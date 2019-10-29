package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RequestOrder;
import com.example.demo.model.ResponseOrder;
import com.example.demo.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testservice;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Demo Application";
	}

	@PostMapping("/addgreeting")
	public ResponseEntity<ResponseOrder> addGreeting(@RequestBody RequestOrder request){
		testservice.addGreeting(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/greeting/{id}")
	public String greeting(@PathVariable("id") int id,@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		String greeting=testservice.getGreeting(id);
		return greeting+" "+name;
	}
	
	@GetMapping("/error")
	public String error() {
		
		return "error";
	}

}
