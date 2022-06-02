package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    @Column(name = "full_name",nullable = true)
    private String fullName;

    @Column(name = "birthday",nullable = true)
    private java.sql.Timestamp birthday;

    @Column(name = "tel",nullable = true)
    private String tel;

    @Column(name = "email",nullable = true)
    private String email;

    @Column(name = "avatar_link",nullable = true)
    private String avatarLink;

    @Column(name = "facebook_link",nullable = true)
    private String facebookLink;


//    @JoinColumn(name = "role_id",nullable = true)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
 //   private Address address;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Settings settings;

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
