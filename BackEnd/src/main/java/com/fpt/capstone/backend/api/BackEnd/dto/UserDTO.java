package com.fpt.capstone.backend.api.BackEnd.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String birthday;
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

    public UserDTO(Integer id, String username, String fullName, String birthday, String tel, String email, String avatarLink, String facebookLink, Integer settingsId, String status, Timestamp created, Integer createdBy, Timestamp modified, Integer modifiedBy) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.birthday = birthday;
        this.tel = tel;
        this.email = email;
        this.avatarLink = avatarLink;
        this.facebookLink = facebookLink;
        this.settingsId = settingsId;
        this.status = status;
        this.created = created;
        this.createdBy = createdBy;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
    }
}
