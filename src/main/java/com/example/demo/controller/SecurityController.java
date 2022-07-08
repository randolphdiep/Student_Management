package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	BCryptPasswordEncoder pwEncoder;

	@Autowired
	UserService userService;

//	@GetMapping(value="/logout")
//	public String logout() {
//		return "security/logout.html";
//	}
//	

//	@GetMapping(value="/login")
//	public String login(Model model) {
//		model.addAttribute("account", new User());
//		return "login";
//	}

//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//        	model.addAttribute("account", new User());
//            return "login";
//        }
//        return "redirect:/";
//    }

//	@PostMapping(value="/login/check")
//	public String loginCheck(@ModelAttribute User account) {
//		User userLogin = userService.getByUserName(account.getUserName());
//		if(userLogin != null)
//			return (userService.isSamePassword(account.getPassword(), userLogin.getPassword()))? "redirect:/list" : "redirect:/login?wrongPass";
//		return "redirect:/login?error";
//	}
	@GetMapping("")
	public String viewHomePage() {
		return "login";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/list";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("newAccount", new User());
		return "register";
	}

	@PostMapping(value = "/register/save")
	public String saveNewAccount(@ModelAttribute User newAccount) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User newUser = userService.getByUserName(newAccount.getUserName());
		if (newUser == null) {
			String encodedPassword = passwordEncoder.encode(newAccount.getPassword());
			newAccount.setPassword(encodedPassword);
//			newAccount.setPassword(pwEncoder.encode(newAccount.getPassword()));
			userService.save(newAccount);
			return "redirect:/login";
		}
		return "redirect:/register?error";
	}
}
