package com.fpt.capstone.backend.api.BackEnd.entity.sercurity;

import lombok.Data;

import java.io.Serializable;



/*
This is class is required for creating a response containing the JWT to be returned to the user.
 */
@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
//    private UserResponse user;

    private  String role;

    public JwtResponse(String jwtToken, String role) {
		this.jwtToken = jwtToken;
		this.role = role;
	}


}
