package com.fpt.capstone.backend.api.BackEnd.entity.sercurity.security;

import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.service.impl.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponseInfo {
    private String jwtToken;
    private UserResponse user;
    private String role;

    public UserResponse userResponse(Users userDetails, String roles) {
        return UserResponse.builder()
                .id(userDetails.getId())
                .fullName(userDetails.getFullName())
                .email(userDetails.getEmail())
                .avatarUrl(userDetails.getAvatarLink())
                .birthday(userDetails.getBirthday())
                .address(userDetails.getAddress())
                .rollNumber(userDetails.getRollNumber())
                .schoolName(userDetails.getSchoolName())
                .facebookLink(userDetails.getFacebookLink())
                .linkedinLink(userDetails.getLinkedinLink())
                .status(userDetails.getStatus())
                .created(userDetails.getCreated())
                .createdBy(userDetails.getCreatedBy())
                .modified(userDetails.getModified())
                .modifiedBy(userDetails.getModifiedBy())
                .role(roles).build();
    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserResponse {

    private long id;

    private String fullName;

    private String email;


    private String avatarUrl;
    private String role;
    private Date birthday;

    private String tel;
    private String rollNumber;
    private String address;

    private String schoolName;

    private String facebookLink;

    private String linkedinLink;

    private String status;

    private Date created;

    private Integer createdBy;

    private Date modified;

    private Integer modifiedBy;
}