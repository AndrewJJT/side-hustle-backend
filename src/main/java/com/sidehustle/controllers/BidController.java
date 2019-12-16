package com.sidehustle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidehustle.beans.Bid;
import com.sidehustle.beans.Task;
import com.sidehustle.beans.User;
import com.sidehustle.data.BidRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") // Spring 4.3
public class BidController {
	@Autowired
	private BidRepository repository;
	
	
	@PostMapping(value = "/bids/add/{uid}/{tid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Bid save(@PathVariable int uid,  @PathVariable int tid, @RequestBody Bid bid) {
		//log.info(task);
		User user = new User();
		user.setUid(uid);
		Task task = new Task();
		task.setTid(tid);
		bid.setUser(user);
		bid.setTask(task);
		System.out.println("BID USER: "+ uid);
		System.out.println("BID TASK: "+ tid);
		System.out.println("This is Bid: " + bid);
		//return null;
		return repository.save(bid);
	}

	@DeleteMapping(value = "/bids/remove/{id}")
	public void RemoveBidById(@PathVariable int id) {
		repository.deleteById(id);
	}
}
