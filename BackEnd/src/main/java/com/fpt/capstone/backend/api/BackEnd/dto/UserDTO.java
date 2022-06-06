package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private Timestamp birthday;
    private String tel;
    private String email;
    private String avatarLink;
    private String facebookLink;
    private Integer settingsId;
    private String status;
    private Timestamp created;
    private Integer createdBy;
    private Timestamp modified;
    private Integer modifiedBy;

}
