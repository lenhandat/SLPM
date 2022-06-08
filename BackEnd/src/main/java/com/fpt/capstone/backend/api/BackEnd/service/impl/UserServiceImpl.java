package com.fpt.capstone.backend.api.BackEnd.service.impl;


import com.fpt.capstone.backend.api.BackEnd.configuration.sercurity.JwtTokenUtil;
import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import com.fpt.capstone.backend.api.BackEnd.service.UserService;
import com.fpt.capstone.backend.api.BackEnd.service.validate.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private Validate validate;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOS;
    }

    private Users convertToEntity(UserDTO usersDTO) throws ParseException {
        Users users = modelMapper.map(usersDTO, Users.class);
        users.setPassword(BCrypt.hashpw(usersDTO.getPassword(), BCrypt.gensalt(12)));
        Date birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(usersDTO.getBirthday());
        users.setBirthday(birthDate);
        users.setSettings(settingsRepository.getById(usersDTO.getSettingsId()));
        return users;
    }

    private UserDTO convertToDto(Users users) {
        UserDTO usersDTO = modelMapper.map(users, UserDTO.class);
        return usersDTO;
    }

    private List<UserDTO> convertToListDto(List<Users> users) {
        List<UserDTO> usersDTO = Arrays.asList(modelMapper.map(users, UserDTO[].class));
        return usersDTO;
    }

    @Override
    public void saveUser(UserDTO userDTO) throws Exception {
        validate.validateUsersAdd(userDTO);
        userRepository.save(convertToEntity(userDTO));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserById(int id) {
        return modelMapper.map(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public void update(UserDTO userDTO) throws Exception {
        Users users = userRepository.getOne(userDTO.getId());
        validate.validateUsersEdit(userDTO);
        users = convertToEntity(userDTO);
        userRepository.save(users);
    }

    @Override
    public Page<UserDTO> listBy(String username, String fullName, String tel, String email, int page, int per_page) {
        Pageable pageable = PageRequest.of(page - 1, per_page);
        Page<Users> users = userRepository.search(username, fullName, tel, email, pageable);
        Page<UserDTO> userDTOs = users.map(users1 -> modelMapper.map(users1, UserDTO.class));
        return userDTOs;
    }


    @Override
    public ResponseEntity<?> getUserInformationByID(int id, String jwtToken) {
        ResponseObject response = new ResponseObject();
        Users users = userRepository.findById(id).orElse(null);
        if (users == null) {
            response.setSuccess(false);
            response.setMessage("Get user infor by id : not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        UserDTO usersDTO = convertToDto(users);
        response.setSuccess(true);
        response.setMessage("Get user infor by id:Succes");
        response.setData(usersDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserInformationByToken(String jwtToken) {
        ResponseObject response = new ResponseObject();
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        Users users = userRepository.findByUsername(userName);
        if (users == null) {
            response.setSuccess(false);
            response.setMessage("Get user infor : not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        UserDTO usersDTO = convertToDto(users);
        response.setSuccess(true);
        response.setMessage("Get user infor:Succes");
        response.setData(usersDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
