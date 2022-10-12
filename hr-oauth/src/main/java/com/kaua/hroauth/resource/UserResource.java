package com.kaua.hroauth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hroauth.service.UserService;
import com.kaua.hroauth.userDTO.UserDTO;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	UserService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
		return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
	}
}
