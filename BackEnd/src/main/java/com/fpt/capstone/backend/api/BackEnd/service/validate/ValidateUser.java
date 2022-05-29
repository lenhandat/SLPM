package com.fpt.capstone.backend.api.BackEnd.service.validate;

import org.springframework.stereotype.Service;

@Service
public class ValidateUser {
    public boolean validateInteger(String value, String regex) {
        return value.matches(regex);
    }
}
