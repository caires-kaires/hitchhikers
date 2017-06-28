package com.caronas.hitchhikers.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caronas.hitchhikers.model.User;
import com.caronas.hitchhikers.model.dto.UserDto;
import com.caronas.hitchhikers.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/users")
public class UserRS {

	@Autowired
	private UserRepository repository;

	@PostMapping
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody User user) {

		User saved = repository.save(user);
		UserDto dto = new UserDto(saved.getId(), saved.getName(), saved.getEmail(), saved.getCars());

		return ResponseEntity.ok(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto>> getUsers() {
		/* JAVA 8 */
		List<UserDto> usersDto = repository.findAll().stream()
				.map(user -> new UserDto(user.getId(), user.getName(), user.getEmail(), user.getCars()))
				.collect(Collectors.toList());
		
		/* Java Roots 
		List<UserDto> userList = new ArrayList<>();
		for (User user : repository.findAll()) {
			UserDto dto = new UserDto(user.getId(), user.getName(), user.getEmail(), user.getCars());
			userList.add(dto);
		}*/ 
		
		return ResponseEntity.ok(usersDto);
	}
}
