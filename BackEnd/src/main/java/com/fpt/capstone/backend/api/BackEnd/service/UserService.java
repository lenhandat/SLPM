package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.UpdateUserInfoDto;
import com.fpt.capstone.backend.api.BackEnd.dto.UserChangePasswordDto;
import com.fpt.capstone.backend.api.BackEnd.dto.UserRegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<?> getUserInformation(String jwtToken) throws Exception;

    ResponseEntity<?> changePassword(UserChangePasswordDto userChangePasswordDto, String jwtToken) throws Exception;

    ResponseEntity<?> saveAvatarLink(String url, String token) throws Exception;

    ResponseEntity<?> getAllUsers(String jwtToken) throws Exception;

    ResponseEntity<?> getUserInformationById(long id, String jwtToken) throws Exception;

    ResponseEntity<?> getNumberStaff(String jwtToken) throws Exception;

    ResponseEntity<?> getAllUsers(String name, int page, int size, String sort, String jwtToken) throws Exception;

    ResponseEntity<?> getStaffPaging(String name, int page, int size, String sort, String jwtToken) throws Exception;

    ResponseEntity<?> putUserInformationById(UpdateUserInfoDto userInfo, long id) throws Exception;

    ResponseEntity<?> isActiveUserById(long id) throws Exception;

    ResponseEntity<?> searchByName(String name, int page, int size, String sort, String jwtToken) throws Exception;

    ResponseEntity<?> addListUsers(UserRegisterDTO userRegisterDto) throws Exception;
}
