package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class SettingsDTO {
    private Integer id;
    private Integer typeId;
    private String title;
    private String value;
    private Byte displayOrder;
    private String status;
    private Date created;
    private Integer created_by;
    private Date modified;
    private Integer modified_by;
    private String createdByUser;
    private String modifiedByUser;



}
