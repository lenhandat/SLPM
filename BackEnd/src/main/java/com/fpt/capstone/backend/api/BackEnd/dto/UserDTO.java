package com.fpt.capstone.backend.api.BackEnd.dto;


import com.fpt.capstone.backend.api.BackEnd.entity.Role;

import java.util.Set;


public class UserDTO {
    private String username;
    private String password;

    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
