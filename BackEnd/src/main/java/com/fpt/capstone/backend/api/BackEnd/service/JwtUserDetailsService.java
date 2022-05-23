package com.fpt.capstone.backend.api.BackEnd.service;


import com.fpt.capstone.backend.api.BackEnd.dto.UsersDTO;
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
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private  ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add((GrantedAuthority)new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new User(user.getUsername(), user.getPassword(),authorities);
//        return new CustomUserDetails(user);
    }

    public Users createUser(Users users){
        Role rollUser = new Role();
        rollUser.setId(1);
        rollUser.setRoleName("Student");
        users.setRole(rollUser);

        users.setPassword(bcryptEncoder.encode(users.getPassword()));

        users.setStatusId(1);
        users.setCreatedBy(0);

        java.sql.Timestamp date= new java.sql.Timestamp(System.currentTimeMillis());
        users.setCreated(date);
        users.setModified(date);
        users.setModifiedBy(0);

        return userRepository.save(users);
    }

    public void updateUser(UsersDTO usersDTO){
//        Users users = mapper.map(usersDTO, Users.class);
//        users.setRole(getRole(usersDTO.getRoleId()));
//
        java.sql.Timestamp date= new java.sql.Timestamp(System.currentTimeMillis());

        userRepository.updateUser(usersDTO.getFullName(),usersDTO.getBirthday(),usersDTO.getTel(),
                usersDTO.getEmail(),usersDTO.getAvatarLink(),usersDTO.getRoleId(),date,0,usersDTO.getId());
    }

    public Role getRole(int id){
        return roleRepository.findRoleById(id);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}
