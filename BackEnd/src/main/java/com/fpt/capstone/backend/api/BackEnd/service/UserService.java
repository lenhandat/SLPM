package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUser();

    void saveUser(UserDTO user) throws Exception;

    void deleteUser(int id);

    UserDTO findUserById(int id);

    void update (UserDTO userDTO) throws Exception;
    Page<UserDTO> listBy(String username, String fullName, String tel , String email, int page, int per_page);

    ResponseEntity<?> getUserInformationByID(int id, String jwtToken) ;
    ResponseEntity<?> getUserInformationByToken( String jwtToken) ;

}
