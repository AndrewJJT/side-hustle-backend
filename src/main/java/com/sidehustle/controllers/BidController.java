package com.sidehustle.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidehustle.beans.Bid;
import com.sidehustle.beans.User;
import com.sidehustle.data.BidRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") // Spring 4.3
public class BidController {
	@Autowired
	private BidRepository repository;
	
	
	@PostMapping(value = "/bids/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Bid save(@RequestBody Bid bid,HttpSession session) {
		//log.info(task);
		System.out.println("This is Bid: " + bid);
		//return null;
		return repository.save(bid);
	}
}
