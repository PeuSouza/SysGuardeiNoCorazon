package com.devpaula.ifpe.model.entidades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

	@GetMapping("/")
	public String initial(Model m) {
		
		return "index";
		
	}
	
}