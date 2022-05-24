package com.fpt.capstone.backend.api.BackEnd.entity.sercurity;



import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class UserResponse {

    private long id;

    private String username;

    private Set<String> roles;

    public UserResponse() {
    }

    public UserResponse(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public UserResponse userResponse(UserDetails userDetails, Set<String> roles) {
        UserResponse u = new UserResponse();
        u.setUsername(userDetails.getUsername());
        u.setRoles(roles);
        return u;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
