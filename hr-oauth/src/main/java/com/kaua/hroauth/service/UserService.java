package com.kaua.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hroauth.feignClient.UserFeignClient;
import com.kaua.hroauth.userDTO.UserDTO;

@Service
public class UserService {
	
	private static Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserFeignClient userFeignClient;
	
	public UserDTO findByEmail(String email) {
		UserDTO user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			LOG.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		LOG.info("Email found: " + email);
		return user;
	}
}
