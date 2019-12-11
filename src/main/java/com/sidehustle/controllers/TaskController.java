package com.sidehustle.controllers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.MediaType;
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
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") // Spring 4.3
public class TaskController {
	
	private static final Logger log = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepo;
	
	//Get All Tasks
	@GetMapping(value="/tasks")
	public List<Task> findAll(){
		return repository.findAll();
	}
	
	//GET One Task based on task id 
	@GetMapping(value = "/tasks/task/{t_id}")
	public Task getTaskDetailById(@PathVariable int t_id) {
		Optional <Task> opt = repository.findById(t_id);
			if(opt.isPresent()) {
				return opt.get();
			}
			else {
				return new Task();//return null will result in someone having to handle errors
			}
	}
	
	/*
	 * // GET Tasks for One User based on User id //TODO Probably don't need this,
	 * just do get user by id in user controller
	 * 
	 * @GetMapping(value = "/tasks/user/{uid}") public List<Task>
	 * searchByUserId(@PathVariable int uid){ return repository.findByUserUid(uid);
	 * }
	 */

/*	// CREATE a task by an existing user
	@PostMapping(value = "/users/{uid}/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task save(@PathVariable int uid, @RequestBody Task task) throws InvalidConfigurationPropertyValueException {
		log.info(task);
		Optional<User> user = userRepo.findById(uid);
		if (user.isPresent()) {	
			task.setUser(user.get());
			return repository.save(task);
		}else {
			return new Task();
		}*/
		
//		return userRepo.findById(uid).map(user -> {
//			task.setUser(user);
//			return repository.save(task);
//		}).orElseThrow(() -> new ResourceAccessException("user is not found")); }
	
	

}
