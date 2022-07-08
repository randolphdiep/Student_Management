package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ListStudent;
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

	@GetMapping(value = "/addform")
	public String showAddForm(Model model) {
		model.addAttribute("editedStudent", new ListStudent());
		return "register-student";
	}

	@GetMapping(value = "/add")
	public String addStudent() {
		return "redirect:/addform?add";
	}

	@GetMapping(value = "/saveStudent")
	public String search2(@RequestParam(required = false) String id, @RequestParam(required = false) String code,
			@RequestParam(required = false) String name, @RequestParam(required = false) String birthday,
			@RequestParam(required = false) String address, @RequestParam(required = false) String score) {
		LocalDate date = null;
		if (birthday != "") {
			date = LocalDate.parse(birthday);
		}
		double averageScore = 0;
		if (score != "") {
			averageScore = Double.parseDouble(score);
		}
		if (id == null) {
			Student newStudent = new Student(code, name);
			studentService.save(newStudent);
			List<Student> students = studentService.findAll();
			int newStudentId = students.get(students.size() - 1).getStudentId();
			StudentInfo newStudentInfo = new StudentInfo(new StudentIdentity(newStudentId, newStudentId), address,
					averageScore, date);
			studentInfoService.save(newStudentInfo);
		} else {
			int studentId = Integer.parseInt(id);
			Student newStudent = new Student(studentId, code, name);
			studentService.save(newStudent);
			StudentInfo newStudentInfo = new StudentInfo(new StudentIdentity(studentId, studentId), address,
					averageScore, date);
			studentInfoService.save(newStudentInfo);
		}

		List<Student> students = studentService.findAll();
		int newStudentId = students.get(students.size() - 1).getStudentId();
		StudentInfo newStudentInfo = new StudentInfo(new StudentIdentity(newStudentId, newStudentId), address,
				averageScore, date);
		studentInfoService.save(newStudentInfo);
		return "redirect:/list";
	}

	@GetMapping(value = "/edit")
	public String editStudentInfo(@RequestParam int editStudentId, Model model) {
		Student editStudent = studentService.findById(editStudentId);
		StudentInfo editStudentInfo = studentInfoService.findById(new StudentIdentity(editStudentId, editStudentId));
		ListStudent listStudent = new ListStudent(editStudentId, 0, editStudent.getStudentCode(),
				editStudent.getStudentName(), editStudentInfo.getDateOfBirth(), editStudentInfo.getAddress(),
				editStudentInfo.getAverageScore());
		model.addAttribute("editedStudent", listStudent);
		return "register-student";
	}

	@GetMapping(value = "/delete")
	public String deleteStudentInfo(@RequestParam int deleteStudentId) {
		studentService.deleteById(deleteStudentId);
		studentInfoService.deleteById(new StudentIdentity(deleteStudentId,deleteStudentId));
		return "redirect:/list";
	}
	
}
