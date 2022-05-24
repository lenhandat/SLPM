package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthday")
    private java.sql.Timestamp birthday;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar_link")
    private String avatarLink;

    @Column(name = "facebook_link")
    private String facebookLink;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "created")
    private java.sql.Timestamp created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "modified")
    private java.sql.Timestamp modified;

    @Column(name = "modified_by")
    private Integer modifiedBy;


}
