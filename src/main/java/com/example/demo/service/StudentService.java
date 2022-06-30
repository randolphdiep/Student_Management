package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public void saveById(int studentId) {
		Student student = studentRepo.findById(studentId).get();
		studentRepo.save(student);
	}
	
	public Student findById(int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}
	
	public List<Student> findAll(){
		return (List<Student>) studentRepo.findAll();
	}
	
	public void deleteById(int studentId) {
		studentRepo.deleteById(studentId);
	}
	
	public List<Student> searchByStCode(String studentCode){
		List<Student> students = new ArrayList<Student>();
		for (Student student : studentRepo.findAll()) {
			if (student.getStudentCode().toLowerCase().contains(studentCode.toLowerCase())){
				students.add(student);
			}
		}
		return students;		
	}
	
	public List<Student> searchByStName(String studentName){
		List<Student> students = new ArrayList<Student>();
		for (Student student : studentRepo.findAll()) {
			if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())){
				students.add(student);
			}
		}
		return students;		
	}
//	public List<User> userSearcher(String firstName, String lastName){
//	if (firstName != null && lastName != null) return getByFullName(firstName, lastName);
//	else if (firstName == null && lastName != null) return getByLastName(lastName);
//	else if (firstName != null && lastName == null) return getByFirstName(firstName);
//	else return new ArrayList<User>();
//}
}
