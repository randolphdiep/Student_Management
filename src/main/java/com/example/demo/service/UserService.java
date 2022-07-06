package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository usRepo;
	
	public void save(User user) {
		usRepo.save(user);
	}
	
//	public void saveById(int userId, User userUpdated) {
//		User user = usRepo.findById(userId).get();
//		user.setUserName(userUpdated.getUserName());
//		user.setPassword(userUpdated.getPassword());
//		usRepo.save(user);
//	}
	
//	public void saveById(int userId) {
//		User user = usRepo.findById(userId).get();
//		usRepo.save(user);
//	}
	
	public User findById(int id) {
		User user = usRepo.findById(id).get();
		return user;
	}
	
	public List<User> findAll(){
		return (List<User>) usRepo.findAll();
	}
	
	
	
//	public List<User> userSearcher(String firstName, String lastName){
//		if (firstName != null && lastName != null) return getByFullName(firstName, lastName);
//		else if (firstName == null && lastName != null) return getByLastName(lastName);
//		else if (firstName != null && lastName == null) return getByFirstName(firstName);
//		else return new ArrayList<User>();
//	}
//	
	public User getByUserName(String userName){ 
		for (User user : usRepo.findAll()) {
			if (user.getUserName().toLowerCase().equals(userName.toLowerCase())) {
				return user;
			}
		}
		return null;
	}
	
	public boolean isSamePassword(String firstPass, String secondPass) {
		return firstPass.equals(secondPass)? true:false;
	}
//	
//	public List<User> getByLastName(String lastName){
//		List<User> users = new ArrayList<User>();
//		for (User user : usRepo.findAll()) {
//			if(user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
//				users.add(user);
//			}
//		}
//		return users;
//	}
//	
//	public List<User> getByFullName(String firstName, String lastName){
//		List<User> users = new ArrayList<User>();
//		for (User user : usRepo.findAll()) {
//			if (user.getFirstName().toLowerCase().contains(firstName.toLowerCase()) &&
//				user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
//				users.add(user);
//			}
//		}
//		return users;
//	}
	
}
