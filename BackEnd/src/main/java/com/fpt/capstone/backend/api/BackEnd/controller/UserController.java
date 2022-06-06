package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAll")
    public ResponseEntity<?> findUserBy(@RequestParam("key_username") String key_username,
                                        @RequestParam("key_fullName") String key_fullName,
                                        @RequestParam("key_tel") String key_tel,
                                        @RequestParam("key_email") String key_email,
                                        @RequestParam("page") int page,
                                        @RequestParam("per_page") int per_page) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            Page<UserDTO> userDTOS = userService
                    .listBy(key_username, key_fullName, key_tel, key_email, page, per_page);
            List<UserDTO> userDTOList = userDTOS.getContent();
            response.setSuccess(true);
            response.setMessage("Show list subject success");
            response.setData(userDTOList);
            response.setTotal(userDTOS.getTotalElements());
            response.setCurrentPage(page);
            response.setPerPages(per_page);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Show list user fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editSubject(@RequestBody UserDTO userDTO) throws Exception {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Update subject success");
            userService.update(userDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Update subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
