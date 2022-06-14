package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

@Data
public class UserChangePWDTO {
    private String password;
    private String oldPassword;
}
