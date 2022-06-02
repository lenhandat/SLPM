package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.Data;

@Data
public class IterationsDTO {
    private Integer id;
    private Integer subjectId;
    private String name;
    private Integer duration;
    private String status;
    private java.sql.Timestamp created;
    private Integer createdBy;
    private java.sql.Timestamp modified;
    private Integer modifiedBy;
}
