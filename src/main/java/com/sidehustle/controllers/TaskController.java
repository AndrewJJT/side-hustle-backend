package com.sidehustle.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidehustle.beans.Task;
import com.sidehustle.data.TaskRepository;
import com.sidehustle.data.UserRepository;


@RestController 
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")  
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
	
	@DeleteMapping(value = "/tasks/task/{t_id}")
	public void RemoveTaskById(@PathVariable int t_id) {
		repository.deleteById(t_id);
	}
	
	
	@PostMapping(value = "/tasks/task/update/{t_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task updateTasksave(@PathVariable int t_id, @Valid @RequestBody Task task) {
		System.out.println("Updating ... ");
		Task taskFromDb = repository.findById(t_id).get();
		taskFromDb.setTcity(task.getTcity());
		taskFromDb.setTdesc(task.getTdesc());
		taskFromDb.setTduration(task.getTduration());
		taskFromDb.setTprice(task.getTprice());
		taskFromDb.setTstate(task.getTstate());
		taskFromDb.setTstreet(task.getTstreet());
		taskFromDb.setTtitle(task.getTtitle());
		return repository.save(taskFromDb);
		
	}
	
}
