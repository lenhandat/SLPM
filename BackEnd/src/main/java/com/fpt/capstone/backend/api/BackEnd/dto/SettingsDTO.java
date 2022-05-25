package com.fpt.capstone.backend.api.BackEnd.dto;


import lombok.Data;

@Data
public class SettingsDTO {
    private Integer id;
    private Integer typeId;
    private String title;
    private String value;
    private Integer displayOrder;
    private String status;
    private java.sql.Timestamp created;
    private Integer createdBy;
    private java.sql.Timestamp modified;
    private Integer modifiedBy;
}
