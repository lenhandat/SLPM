package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class UserDTO implements Serializable {
    private final Integer id;
    private final String username;
    private final String password;
    private final String fullName;
    private final Timestamp birthday;
    private final String tel;
    private final String email;
    private final String avatarLink;
    private final String facebookLink;
    private final Integer settingsId;
    private final Integer statusId;
    private final Timestamp created;
    private final Integer createdBy;
    private final Timestamp modified;
    private final Integer modifiedBy;


}
