package com.example.demo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ScreenListController;
import com.example.demo.model.ListStudent;
import com.example.demo.model.Student;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;
import com.example.demo.model.User;
import com.example.demo.service.ListStudentService;
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
    
    @Autowired
    private ListStudentService listStudentService;
    
    @Autowired
    private ScreenListController screenListController;
    
    @Override
    public void run(String...args) throws Exception {
    	
//    	userService.save(new User("helloooo","1234"));
//    	userService.save(new User("whatup","1234"));
//    	userService.save(new User("letcheckout","1234"));
//    	userService.save(new User("ok","1234"));
//    	System.out.println(studentService.findById(14).toString());
//    	User updated = new User(1,"ok", "1");
//    	userService.save(updated);
//    	User loginU = studentService.getByUserName("randolphfdfh");
//    	System.out.println(studentService.isSamePassword("null", loginU.getPassword()));
//      List <Student> students = studentService.findAll();
//      students.forEach(student -> System.out.println(student.toString()));
//      List <User> users = userService.findAll();
//      users.forEach(user -> System.out.println(user.toString()));
//    	Student new2 = new Student("ThanhMeoMeo", "STU710");
//    	System.out.println(new2.getStudentId()+ "IDDD");
//    	studentService.save(new2);
//    	List<Student> hello = studentService.findAll();
//    	hello.forEach(student -> System.out.println(student.toString()));
//    	LocalDate date = LocalDate.now();  
//    	String pattern = "yyyy-MM-dd";
//    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//    	Date date = simpleDateFormat.parse("2021-06-30");
//    	LocalDate date = LocalDate.parse("2022-06-08");
//    	System.out.println(date.toString());
//    	date=spl.parse(d);
//    	StudentInfo newInfo = new StudentInfo(new StudentIdentity(null, null), "tfdestcdcd",10.0, date);
//    	studentInfoService.save(newInfo);
//      List <StudentInfo> students = studentInfoService.findAll();
//      students.forEach(student -> System.out.println(student.toString()));
//    	for (StudentInfo studentInfo : lists) {
//			System.out.println(studentInfo.toString());
//		}

//    	List<StudentInfo> hello = studentInfoService.searchByDate(date);
//    	hello.forEach(student -> System.out.println(student.toString()));
    	
//    	List<Student> meo = studentService.searchByStName("ran");
//    	meo.forEach(student -> System.out.println(student.toString()));
    	
//    	System.out.println(studentService.generateStCode());
//    	User userLogin = userService.getByUserName("meomeo");
//    	System.out.println(userLogin.toString());
//    	User userLogin = userService.getByUserName("randolpcdchcd");
//    	System.out.println(userLogin.toString());
//		if(userLogin != null) {
//			if(userService.isSamePassword(("123"), userLogin.getPassword())) {
//				System.out.println("hello meo meo");
//			}
//		}
//		else {
//			System.out.println("fuck diu");
//		}
//    	List<Student> studentList = studentService.findAll();
//    	for (Student student : studentList) {
//    		System.out.println(student.toString());
//		}
    	
//    	List<StudentInfo> studentInfoList = studentInfoService.findAll();
//    	for (StudentInfo student : studentInfoList) {
//    		System.out.println(student.toString());
//		}
    	
//    	List<ListStudent> list = new ArrayList<>();
//    	for(int i=0; i < studentList.size(); i++) {
//    		list.add(new ListStudent(studentList.get(i).getStudentCode(), studentList.get(i).getStudentName(), studentInfoList.get(i).getDateOfBirth(), studentInfoList.get(i).getAddress(), studentInfoList.get(i).getAverageScore()));
//    	}
//    	
//    	for (ListStudent listStudent : list) {
//    		System.out.println(listStudent.toString());
//		}
    	
//    	screenListController.search2(new ListStudent("sdf","m"));
    	
//    	List<ListStudent> list = listStudentService.searchListStudent(null, "n");
//    	list.forEach(student -> System.out.println(student.toString()));
    	
//    	LocalDate date = LocalDate.parse("2022-06-08");
//    	List<StudentInfo> list = studentInfoService.searchByDate(date);
//    	String date = "2022-06-08";
//    	List<ListStudent> list = listStudentService.searchByBirthday(date);
//    	list.forEach(student -> System.out.println(student.toString()));
    }
}
