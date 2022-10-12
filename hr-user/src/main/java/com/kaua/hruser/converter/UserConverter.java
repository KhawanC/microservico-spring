package com.kaua.hruser.converter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaua.hruser.form.UserForm;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.model.User;

@Service
public class UserConverter {
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public User FormToModel(UserForm form, Set<Role> roles) {
		User user = new User();
		
		user.setEmail(form.getEmail());
		user.setName(form.getName());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setRoles(roles);
		
		return user;
	}
	
	public UserForm ModelToForm(User user) {
		UserForm form = new UserForm();
		
		form.setEmail(user.getEmail());
		form.setName(user.getName());
		form.setPassword(user.getPassword());
		
		return form;
	}
} 
