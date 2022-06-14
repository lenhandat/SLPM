package com.fpt.capstone.backend.api.BackEnd.service.impl.security;


import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
//            GrantedAuthority authorities = user.getSettings().stream()
//                    .map(role -> new SimpleGrantedAuthority(role.getName()))
//                    .collect(Collectors.toSet());
            final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add((GrantedAuthority) new SimpleGrantedAuthority(user.getSettings().getValue()));


            return UserDetailsImpl.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .avatarUrl(user.getAvatarLink())
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .authorities(authorities).build();
        }
        else {
            throw new UsernameNotFoundException(email);
        }
    }
}
