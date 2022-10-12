package com.kaua.hruser.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hruser.converter.RoleConverter;
import com.kaua.hruser.converter.UserConverter;
import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.form.UserForm;
import com.kaua.hruser.model.Role;
import com.kaua.hruser.model.User;
import com.kaua.hruser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	UserConverter converter;

	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleConverter roleConverter;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).get(); 
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email).get();
	}

	public User save(UserForm form) {
		Set<Role> roles = new HashSet<>();
		for (RoleEnum role : form.getRoles()) {
			roles.add(roleConverter.EnumToModel(role));
		}
		
		User user = converter.FormToModel(form, roles);

		return repository.save(user);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
