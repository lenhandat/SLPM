package com.fpt.capstone.backend.api.BackEnd.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SettingsDTO implements Serializable {
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
