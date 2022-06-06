package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private  Integer id;
    private  String username;
    private  String password;
    private  String fullName;
    private  Timestamp birthday;
    private  String tel;
    private  String email;
    private  String avatarLink;
    private  String facebookLink;
    private  Integer settingsId;
    private  Integer statusId;
    private  Timestamp created;
    private  Integer createdBy;
    private  Timestamp modified;
    private  Integer modifiedBy;



}
