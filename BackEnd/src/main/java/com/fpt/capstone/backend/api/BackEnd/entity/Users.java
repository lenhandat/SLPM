package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
@Data

public class Users  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
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
