package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class IterationsListDTO {
    private Integer id;
    private Integer subjectId;
    private String name;
    private Integer duration;
    private String subjectName;
    private String status;
    private Date created;
    private Integer created_by;
    private Date modified;
    private Integer modified_by;
    private String createdByFullName;
    private String modifiedByFullName;
}
