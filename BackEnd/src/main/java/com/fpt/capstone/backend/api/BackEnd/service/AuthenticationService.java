package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.UserLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    ResponseEntity<?> authenticate(UserLoginDto userLoginDto) throws AuthenticationException;

    ResponseEntity<?> getVerifyCode(String email) throws Exception;
}
