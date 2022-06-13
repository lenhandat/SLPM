package com.fpt.capstone.backend.api.BackEnd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import lombok.Data;

import java.util.Date;

@Data

public class UserSignInDTO {
    private Integer id;
    private String username;
    private String fullName;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthday;
    private String tel;
    private String email;
    private String avatarLink;
    private String facebookLink;
    private Settings settings;
}
