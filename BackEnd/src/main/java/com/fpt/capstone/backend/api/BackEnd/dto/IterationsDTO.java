package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class IterationsDTO {
    private Integer id;
    private Integer subjectId;
    private String name;
    private Integer duration;
    private String status;
    private Date created;
    private Integer created_by;
    private Date modified;
    private Integer modified_by;
    private String createdByUser;
    private String modifiedByUser;
}
