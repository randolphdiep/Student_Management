package com.example.demo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;
import com.example.demo.service.StudentInfoService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

@Component
public class MyRunner implements CommandLineRunner {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentInfoService studentInfoService;
    
    @Override
    public void run(String...args) throws Exception {
    	
//    	userService.save(new User("helloooo","1234"));
//    	userService.save(new User("whatup","1234"));
//    	userService.save(new User("letcheckout","1234"));
//    	userService.save(new User("ok","1234"));
//    	System.out.println(studentService.findById(14).toString());
//    	User updated = new User("randolphdiepmeomeo", "sivhdvn2001");
//    	userService.saveById(1, updated);
//    	User loginU = studentService.getByUserName("randolphfdfh");
//    	System.out.println(studentService.isSamePassword("null", loginU.getPassword()));
//        List <Student> students = studentService.findAll();
//        students.forEach(student -> System.out.println(student.toString()));
//        List <User> users = userService.findAll();
//        users.forEach(user -> System.out.println(user.toString()));
//    	Student new2 = new Student(3, "Bao", "STU510");
//    	studentService.save(new2);
//    	LocalDate date = LocalDate.now();  
//    	String pattern = "yyyy-MM-dd";
//    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//    	Date date = simpleDateFormat.parse("2021-06-30");
//    	LocalDate date = LocalDate.parse("2022-06-30");
//    	System.out.println(date.toString());
//    	date=spl.parse(d);
//    	StudentInfo newInfo = new StudentInfo(new StudentIdentity(3, 3), "meomeo",10.0, date);
//    	studentInfoService.save(newInfo);
    	List<StudentInfo> lists = studentInfoService.findAll();
    	for (StudentInfo studentInfo : lists) {
			System.out.println(studentInfo.toString());
		}
//    	for (StudentInfo studentInfo : lists) {
//			System.out.println(studentInfo.toString());
//		}
    	
    	
    }
}
