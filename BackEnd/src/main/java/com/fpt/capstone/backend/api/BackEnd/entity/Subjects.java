package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subjects")
@Data
public class Subjects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "created")
    private java.sql.Timestamp created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "modified")
    private java.sql.Timestamp modified;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Iterations> iterations;
}
