package br.com.word.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworlld")
public class HelloWorldController {
	
	@GetMapping 
	public String hello() {
		return "Persistência";
	}

}