package com.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Principal principal, Model model) {
		model.addAttribute("principal", principal);
		return "home";
	}
	
	@GetMapping("/err/denied")
	public String denied() {
		return "err/denied";
	}
}
