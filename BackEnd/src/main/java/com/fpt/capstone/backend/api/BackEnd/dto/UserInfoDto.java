package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private Integer id;
    private String email;
    private String fullName;
    private Date birthday;
    private String tel;
    private String address;
    private String rollNumber;
    private String schoolName;
    private String avatarLink;
    private String facebookLink;
    private String linkedinLink;
    private Integer roleId;
    private String status;
    private Date created;
    private Integer createdBy;
    private Date modified;
    private Integer modifiedBy;
}
