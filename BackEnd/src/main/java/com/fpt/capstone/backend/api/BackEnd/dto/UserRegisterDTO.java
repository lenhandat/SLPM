package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    private String verificationCode;
    private Boolean enabled;

}
