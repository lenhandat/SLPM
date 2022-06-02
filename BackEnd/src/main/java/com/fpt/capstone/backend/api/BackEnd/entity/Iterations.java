package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "iterations")
@Data
public class Iterations {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonBackReference
    private Subjects subject;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

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
}
