package com.caronas.hitchhikers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caronas.hitchhikers.model.User;
import com.caronas.hitchhikers.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/users")
public class UserRS {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		
		User saved = repository.save(user);
		
		return ResponseEntity.ok(saved);
	}

}
