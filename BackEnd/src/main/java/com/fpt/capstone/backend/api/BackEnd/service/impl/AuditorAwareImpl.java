package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<Integer> {

    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<Integer> getCurrentAuditor() {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepository.findByUsername(userName);
        return Optional.ofNullable(user.getId());
    }
}
