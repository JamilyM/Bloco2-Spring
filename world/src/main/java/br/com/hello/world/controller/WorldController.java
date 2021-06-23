package br.com.hello.world.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworlld")
public class WorldController {
	
	@GetMapping 
	public String world() {
		return "Entender melhor Spring";
	}

}
