package com.sidehustle.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

}
