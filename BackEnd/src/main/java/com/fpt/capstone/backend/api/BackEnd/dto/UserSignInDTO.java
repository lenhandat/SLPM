package com.fpt.capstone.backend.api.BackEnd.dto;

import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserSignInDTO {
    private Integer id;
    private String username;
    private String fullName;
    private Timestamp birthday;
    private String tel;
    private String email;
    private String avatarLink;
    private String facebookLink;
    private Settings settings;
}
