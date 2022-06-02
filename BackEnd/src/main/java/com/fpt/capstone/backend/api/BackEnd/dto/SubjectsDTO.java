package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

@Data
public class SubjectsDTO {
    private Integer id;
    private String code;
    private String name;
    private String status;
    private java.sql.Timestamp created;
    private Integer createdBy;
    private java.sql.Timestamp modified;
    private Integer modifiedBy;
}
