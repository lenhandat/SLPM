package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDetailsService userDetailsService;

//    @GetMapping("/getAll")
//    public ResponseEntity<?> findUserBy(@RequestParam("key_username") String key_username,
//                                        @RequestParam("key_fullName") String key_fullName,
//                                        @RequestParam("key_tel") String key_tel,
//                                        @RequestParam("key_email") String key_email,
//                                        @RequestParam("page") int page,
//                                        @RequestParam("per_page") int per_page) {
//        ResponsePaggingObject response = new ResponsePaggingObject();
//        try {
//            Page<UsersDTO> userDTOS = userService
//                    .listBy(key_username, key_fullName, key_tel, key_email, page, per_page);
//            List<UsersDTO> userDTOList = userDTOS.getContent();
//            response.setSuccess(true);
//            response.setMessage("Get list user successfully");
//            response.setData(userDTOList);
//            response.setTotal(userDTOS.getTotalElements());
//            response.setCurrentPage(page);
//            response.setPerPages(per_page);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Get list user fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PutMapping ("/edit")
//    public ResponseEntity<?> editSubject(@RequestBody UsersDTO userDTO
//                                         ) throws Exception {
//        ResponseObject response = new ResponseObject();
//        try {
//            userService.updateByID(userDTO);
//            response.setSuccess(true);
//            response.setMessage("Update user proflie successfully");
//            response.setData(userDTO);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Update user fail: "  + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ResponseEntity<?> addUser(@RequestBody UsersDTO usersDTO) throws Exception {
//        ResponseObject response = new ResponseObject();
//
//        try {
//            userService.saveUser(usersDTO);
//            response.setSuccess(true);
//            response.setMessage("Add user successfully");
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Add user fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Delete user successfully");
//            userService.deleteUser(id);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Delete user fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<?> findByID(@PathVariable("id") int id) {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Get user successfully");
//            response.setData(userService.findUserById(id));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Get user fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//    @RequestMapping(value = "/changepassword" , method = RequestMethod.POST)
//    public ResponseEntity<?>  principalchangepassword(@RequestBody UserChangePWDTO userChangePWDTO){
//        ResponseObject response = new ResponseObject();
//        try {
//
//            response.setSuccess(true);
//            response.setMessage("Update subject success");
//            userService.changepassword(userChangePWDTO);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Reset password fail: " + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
    @Autowired
    private AuthenticationManager authenticationManager;
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
