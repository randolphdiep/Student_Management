package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ListStudent;
import com.example.demo.model.Student;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;

@Service
public class ListStudentService {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentInfoService studentInfoService;

	public List<ListStudent> findAll() {
		List<Student> studentList = studentService.findAll();
		List<StudentInfo> studentInfoList = studentInfoService.findAll();
		List<ListStudent> list = new ArrayList<>();
		for (int i = 0; i < studentList.size(); i++) {
			list.add(new ListStudent(studentList.get(i).getStudentId(), i + 1, studentList.get(i).getStudentCode(),
					studentList.get(i).getStudentName(), studentInfoList.get(i).getDateOfBirth(),
					studentInfoList.get(i).getAddress(), studentInfoList.get(i).getAverageScore()));
		}
		return list;
	}

	public List<Student> searchStudent(String code, String name) {

		List<Student> searchedStudent = new ArrayList<>();
		if (code != null && name == null) {
			searchedStudent = studentService.searchByStCode(code);
		} else if (code == null && name != null) {
			searchedStudent = studentService.searchByStName(name);
		} else if (code != null && name != null) {
			searchedStudent = studentService.getByCodeAndName(code, name);
		}

		return searchedStudent;
	}

	public List<ListStudent> searchByDate(List<ListStudent> listStudents, String birthday) {
		LocalDate date = LocalDate.parse(birthday);
		List<ListStudent> searchedListStudent = new ArrayList<>();
		for (ListStudent listStudent : listStudents) {
			if (listStudent.getBirthday().equals(date)) {
				searchedListStudent.add(listStudent);
			}
		}
		return searchedListStudent;
	}

	public List<ListStudent> searchListStudent(String code, String name, String birthday) {
		List<ListStudent> searchedListStudent = new ArrayList<>();
		if (code == "" && name == "" && birthday == "") {
			searchedListStudent = findAll();
		} else {
			List<Student> searchedStudent = searchStudent(code, name);
			for (int i = 0; i < searchedStudent.size(); i++) {
				Student student = searchedStudent.get(i);
				StudentInfo studentInfo = studentInfoService
						.findById(new StudentIdentity(student.getStudentId(), student.getStudentId()));
				searchedListStudent.add(new ListStudent(student.getStudentId(), i + 1, student.getStudentCode(),
						student.getStudentName(), studentInfo.getDateOfBirth(), studentInfo.getAddress(),
						studentInfo.getAverageScore()));
			}
		}
		if (birthday != "")
			searchedListStudent = searchByDate(searchedListStudent, birthday);
		return searchedListStudent;
	}

	public List<ListStudent> searchByBirthday(String birthday) {
		List<ListStudent> searchedListStudent = new ArrayList<>();
		LocalDate date = LocalDate.parse(birthday);
		List<StudentInfo> studentInfos = studentInfoService.searchByDate(date);
		for (int i = 0; i < studentInfos.size(); i++) {
			StudentInfo studentInfo = studentInfos.get(i);
			Student student = studentService.findById(studentInfo.getStudentIdentity().getStudentId());
			searchedListStudent.add(
					new ListStudent(student.getStudentId(), i + 1, student.getStudentCode(), student.getStudentName(),
							studentInfo.getDateOfBirth(), studentInfo.getAddress(), studentInfo.getAverageScore()));
		}
		return searchedListStudent;
	}

}
