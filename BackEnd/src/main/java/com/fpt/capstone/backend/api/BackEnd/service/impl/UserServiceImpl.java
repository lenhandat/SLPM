package com.fpt.capstone.backend.api.BackEnd.service.impl;


import com.fpt.capstone.backend.api.BackEnd.configuration.sercurity.JwtTokenUtil;

import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;

import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import com.fpt.capstone.backend.api.BackEnd.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public List<Users> getAllUser() {
        return (List<Users>) userRepository.findAll();
    }

    private Users convertToEntity(UserDTO usersDTO) {
        Users users = modelMapper.map(usersDTO, Users.class);
        users.setPassword(BCrypt.hashpw(usersDTO.getPassword(), BCrypt.gensalt(12)));
        return users;
    }

    private UserDTO convertToDto(Users users) {

        UserDTO usersDTO = modelMapper.map(users, UserDTO.class);
//        usersDTO.setSettingsDTO(new SettingsDTO(users.getSettings().getId(), users.getSettings().getValue()));
        return usersDTO;
    }

    private List<UserDTO> convertToListDto(List<Users> users){
        List<UserDTO> usersDTO = Arrays.asList(modelMapper.map(users,UserDTO[].class));
         return usersDTO;
    }
    @Override
    public void saveUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Users> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> getUserInformationByID(int id, String jwtToken) {
        ResponseObject response = new ResponseObject();
        Users users = userRepository.findById(id).orElse(null);
        if (users==null){
            response.setStatus("Fail");
            response.setMessage("Get user infor by id : not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
      UserDTO usersDTO = convertToDto(users);
        response.setStatus("OK");
        response.setMessage("Get user infor by id:Succes");
        response.setData(usersDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserInformationByToken(String jwtToken) {
        ResponseObject response = new ResponseObject();
        String userName= jwtTokenUtil.getUsernameFromToken(jwtToken);
        Users users = userRepository.findByUsername(userName);
        if (users==null){
            response.setStatus("Fail");
            response.setMessage("Get user infor : not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        //User thật không được phép trả về mà phải trả qua dto
        UserDTO usersDTO = convertToDto(users);
        response.setStatus("OK");
        response.setMessage("Get user infor:Succes");
        response.setData(usersDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
