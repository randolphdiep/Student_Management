package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.ListStudent;
import com.example.demo.service.ListStudentService;

@Controller
public class ScreenListController {
	@Autowired
	private ListStudentService listStudentService;
	
	@GetMapping(value = "/list")
	public String showList(Model model) {
		List<ListStudent> list = listStudentService.findAll();
		model.addAttribute("students", list);
		model.addAttribute("listStudent", new ListStudent());
		return "listStudent";
	}

//	@GetMapping(value="/searchField")
//	public String search(Model model) {
//		model.addAttribute("listStudent", new ListStudent());
//		return "redirect:/list";
//	}

	@GetMapping(value = "/searchByField")
	public String search2(Model model,
			@RequestParam (required=false) String code,
			@RequestParam (required=false) String name,
			@RequestParam (required=false) String birthday) {
		List<ListStudent> list = new ArrayList<>();
		if(code == "" && name == "" && birthday != "") {
			list = listStudentService.searchByBirthday(birthday);
		}else {
			list = listStudentService.searchListStudent(code,name, birthday); 
	    	
		}
		model.addAttribute("students", list);
		return "listStudent";
	}
	
	@GetMapping(value = "/account-created")
	public String search3() {
		return "account-created";
	}
}
