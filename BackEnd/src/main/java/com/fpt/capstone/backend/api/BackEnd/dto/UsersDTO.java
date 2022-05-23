package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Integer id;
    private String username;
    private String fullName;
    private java.sql.Timestamp birthday;
    private String tel;
    private String email;
    private String avatarLink;
    private String facebookLink;
    private int roleId;
    private Integer statusId;
    private java.sql.Timestamp created;
    private Integer createdBy;
    private java.sql.Timestamp modified;
    private Integer modifiedBy;


}

