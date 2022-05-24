package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getAllUser();

    void saveUser(Users user);

    void deleteUser(int id);

    Optional<Users> findUserById(int id);

    ResponseEntity<?> getUserInformationByID(int id, String jwtToken) ;
    ResponseEntity<?> getUserInformationByToken( String jwtToken) ;

}
