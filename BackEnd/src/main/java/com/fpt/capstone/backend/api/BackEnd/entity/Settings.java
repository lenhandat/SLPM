package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "settings")
@Data
public class Settings {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private String value;

    @Column(name = "display_order")
    private Integer displayOrder;

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
