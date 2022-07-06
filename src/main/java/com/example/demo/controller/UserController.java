package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@GetMapping(value="/logout")
//	public String logout() {
//		return "security/logout.html";
//	}
//	
	
	@GetMapping(value="/login")
	public String login(Model model) {
		model.addAttribute("account", new User());
		return "login";
	}
	
	@PostMapping(value="/login/check")
	public String loginCheck(@ModelAttribute User account) {
		User userLogin = userService.getByUserName(account.getUserName());
		if(userLogin != null)
			return (userService.isSamePassword(account.getPassword(), userLogin.getPassword()))? "redirect:/list" : "redirect:/login?wrongPass";
		return "redirect:/login?error";
	}
	
	@GetMapping(value="/register")
	public String register(Model model) {
		model.addAttribute("newAccount", new User());
		return "register";
	}

	@PostMapping(value="/register/save")
	public String saveNewAccount(@ModelAttribute User newAccount) {
		User newUser = userService.getByUserName(newAccount.getUserName());
		if(newUser == null) {
			userService.save(newAccount);
			return "redirect:/login";
		}
		return "redirect:/register?error";						
	}
}
