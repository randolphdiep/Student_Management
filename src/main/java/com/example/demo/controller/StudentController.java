package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;
import com.example.demo.service.StudentInfoService;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentInfoService studentInfoService;

	@GetMapping(value = "/add")
	public String addStudent() {
		return "register-student";
	}

	@GetMapping(value = "/saveStudent")
	public String search2(@RequestParam(required = false) String code, @RequestParam(required = false) String name,
			@RequestParam(required = false) String birthday, @RequestParam(required = false) String address,
			@RequestParam(required = false) String score) {
		Student newStudent = new Student(code, name);
		studentService.save(newStudent);

		List<Student> students = studentService.findAll();
		LocalDate date = null;
		if (birthday != "") {
			date = LocalDate.parse(birthday);
		}
		double averageScore = 0;
		if(score != "") {
			averageScore = Double.parseDouble(score);
		}	
		int newStudentId = students.get(students.size() - 1).getStudentId();
		StudentInfo newStudentInfo = new StudentInfo(new StudentIdentity(newStudentId, newStudentId), address,
				averageScore, date);
		studentInfoService.save(newStudentInfo);
		return "redirect:/list";
	}
}
