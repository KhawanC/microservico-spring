package com.kaua.hruser.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hruser.form.UserForm;
import com.kaua.hruser.model.User;
import com.kaua.hruser.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody UserForm form) {
		return new ResponseEntity<>(service.save(form), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<>("User deleted successfuly!", HttpStatus.OK);
	}
}
