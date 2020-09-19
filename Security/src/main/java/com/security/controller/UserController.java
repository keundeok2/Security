package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.domain.UserDto;
import com.security.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/signin")
	public String signinView() {
		return "signin";
	}

	@PostMapping("/signin")
	public String signin(UserDto userDto) {
		userService.addUser(userDto);
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public String signupView() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(UserDto userDto) {
		userService.addUser(userDto);
		return "redirect:/";
	}
	
	@GetMapping("/user/userInfo")
	public String userInfo() {
		return "userInfo";
	}
	
	@GetMapping("/admin/manageUser")
	public String manageUser() {
		return "manageUser";
	}
}
