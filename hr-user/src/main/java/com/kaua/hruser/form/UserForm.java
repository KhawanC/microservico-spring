package com.kaua.hruser.form;

import java.util.Set;

import com.kaua.hruser.enums.RoleEnum;

public class UserForm {

	private String name;

	private String email;

	private String password;

	private Set<RoleEnum> roles;

	public UserForm(String name, String email, String password, Set<RoleEnum> roles) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UserForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEnum> roles) {
		this.roles = roles;
	}

}
