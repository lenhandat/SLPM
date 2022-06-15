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
    private Integer displayOrder;
    private String status;
    private Date created;
    private Integer createdBy;
    private Date modified;
    private Integer modifiedBy;
    private String createdByUser;
    private String modifiedByUser;

}
