package com.sidehustle.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.MediaType;
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
public class UserController {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepo;
	
	//GET User info - tasks and bids 
	@GetMapping(value = "users/{id}")
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
