package com.fpt.capstone.backend.api.BackEnd.service;


import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;

import com.fpt.capstone.backend.api.BackEnd.entity.Role;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.RoleRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface.
It overrides the loadUserByUsername for fetching user details from the database using the username.
The Spring Security Authentication Manager calls this method for getting the user details from the database
when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded
User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database.
Also the password for a user is stored in encrypted format using BCrypt.
Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt.
Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @Autowired
//    private ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add((GrantedAuthority) new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new User(user.getUsername(), user.getPassword(), authorities);
//        return new CustomUserDetails(user);
    }

    public Users createUser(Users users) {



        Role rollUser = new Role();

        users.setRole(rollUser);


        users.setUsername(users.getUsername());
        users.setPassword(bcryptEncoder.encode(users.getPassword()));
        users.setStatusId(1);
        users.setCreatedBy(0);
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        users.setCreated(date);
        users.setModified(date);
        users.setModifiedBy(0);

        return userRepository.save(users);
    }

    public void updateUser(UserDTO usersDTO) {
//        Users users = mapper.map(usersDTO, Users.class);
//        users.setRole(getRole(usersDTO.getRoleId()));
//
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());

        userRepository.updateUser(usersDTO.getFullName(), usersDTO.getBirthday(), usersDTO.getTel(),
                usersDTO.getEmail(), usersDTO.getAvatarLink(), usersDTO.getRole().getId(), date, 0, usersDTO.getId());
    }

    public Role getRole(int id) {
        return roleRepository.findRoleById(id);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
