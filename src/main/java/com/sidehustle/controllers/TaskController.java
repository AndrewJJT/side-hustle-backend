package com.sidehustle.controllers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidehustle.beans.Task;
import com.sidehustle.data.TaskRepository;


@RestController 
public class TaskController {
	
	private static final Logger log = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskRepository repository;
	
	@PostMapping(value = "/tasks/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task save(@RequestBody Task task) {
		log.info(task);
		return repository.save(task);
	}
	
	//All Tasks
	@GetMapping(value="/tasks")
	public List<Task> findAll(){
		return repository.findAll();
	}
	
	// Task Details for 1 task
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
	
	// Tasks for a user
	@GetMapping(value = "/tasks/{u_id}")
	public List<Task> searchByUserId(@PathVariable int uid){
		return repository.findByUserUid(uid);
	}

	

}
