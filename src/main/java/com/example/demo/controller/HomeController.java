//package com.example.demo.controller;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//
//	@GetMapping(value="/")
//	public String redirectToHome() {
//		
//		UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String username = principal.getUsername();
//		return "redirect:/list";
//	}
//}	
