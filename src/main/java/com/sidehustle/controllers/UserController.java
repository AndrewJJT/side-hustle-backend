package com.sidehustle.controllers;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CookieValue;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidehustle.beans.Task;
import com.sidehustle.beans.User;
import com.sidehustle.data.TaskRepository;
import com.sidehustle.data.UserRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")  
public class UserController {
	

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepo;
	
	//GET User by username and password 
	@PostMapping(value = "/users")
	public User login( @RequestBody User tempUser, HttpServletResponse resp) {
		System.out.println("tempUser --------------->" + tempUser);
		User user = userRepo.findByUusernameAndUpassword(tempUser.getUusername(), tempUser.getUpassword());
		System.out.println("--------------------------->>>>" + user);
		if (user != null) {
			System.out.println("in if statement" + user);
			String userId = String.valueOf(user.getUid());
			Cookie cookie = new Cookie("userid", userId);
		
			System.out.println(cookie);
			resp.addCookie(cookie);
		}
		return user;
	}
	
	//GET User info by Session 
	@GetMapping(value = "/users/detail")
	public User getUserInfoBySession( @CookieValue(value = "userid") String userid ) {
		int id = Integer.valueOf(userid);
		Optional<User> user= userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return new User();
		}
		
	}
	
	//GET User info - tasks and bids 
	@GetMapping(value = "/users/{id}")
	public User getUserInfo(@PathVariable int id) {
		Optional<User> user= userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return new User();
		}
	}
	
	// CREATE a task by an existing user
	@PostMapping(value = "/users/{uid}/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task save(@PathVariable int uid, @RequestBody Task task) throws InvalidConfigurationPropertyValueException {
		Optional<User> user = userRepo.findById(uid);
		if (user.isPresent()) {	
			task.setUser(user.get());
			return repository.save(task);
		}else {
			return new Task();
		}
		
//		return userRepo.findById(uid).map(user -> {
//			task.setUser(user);
//			return repository.save(task);
//		}).orElseThrow(() -> new ResourceAccessException("user is not found"));
	}
}
