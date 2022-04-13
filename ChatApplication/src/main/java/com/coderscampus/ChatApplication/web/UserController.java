package com.coderscampus.ChatApplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String home() {
		return "redirect:/welcome";
	}

	// get username via javascript-fetch
	@PostMapping("/welcome/user")
	@ResponseBody
	public User postUser(@RequestBody String username) {
		return userService.newUser(username);
	}

}