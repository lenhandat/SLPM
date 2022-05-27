package com.fpt.capstone.backend.api.BackEnd.controller;


import com.fpt.capstone.backend.api.BackEnd.configuration.sercurity.JwtTokenUtil;
import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.entity.sercurity.JwtRequest;
import com.fpt.capstone.backend.api.BackEnd.entity.sercurity.JwtResponse;

import com.fpt.capstone.backend.api.BackEnd.entity.sercurity.UserResponse;

import org.modelmapper.ModelMapper;

import com.fpt.capstone.backend.api.BackEnd.service.impl.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;


/*
Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets username and password in the
body- Using Spring Authentication Manager we authenticate the username and password.If the credentials are valid,
a JWT token is created using the JWTTokenUtil and provided to the client.
 */
@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO usersDTO) throws Exception {
        ResponseObject response = new ResponseObject();

        try {
            Users users = userDetailsService.createUser(usersDTO);
            response.setStatus("True");
            response.setMessage("Register success");
            //response.setData(userDetailsService.createUser(usersDTO));
            //response.setData(modelMapper.map(users,UserDTO.class));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setStatus("Fail");
            response.setMessage("Register fail catch " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        // return ResponseEntity.ok(userDetailsService.createUser(user));

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        ResponseObject response = new ResponseObject();
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);

            //get role
            response.setStatus("OK");
            response.setMessage("Login success");
            response.setData(new JwtResponse(token, userDetails.getAuthorities().iterator().next().toString()));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AuthenticationException authenticationException) {
            response.setStatus("Fail");
            response.setMessage("Login fail username or password wrong");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            response.setStatus("Fail");
            response.setMessage("Login fail " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }


    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
