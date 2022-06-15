package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.entity.CustomUserDetails;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<Long> getCurrentAuditor() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        //CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
        //        .getPrincipal();
       // String userName = userDetails.getUsername();
        Optional<Users> user = userRepository.findByEmail(email);

        return Optional.ofNullable(user.get().getId());
        //return null;
    }
}
