package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "users")
@Data

public class Users extends  Auditable  implements Serializable {
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
   // @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birthday;

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


    @Column(name = "status")
    private String status;

}
