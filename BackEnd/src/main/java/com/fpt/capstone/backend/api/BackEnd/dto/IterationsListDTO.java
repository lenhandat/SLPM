package com.fpt.capstone.backend.api.BackEnd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IterationsListDTO {
    private Integer id;
    private Integer subjectId;
    private String name;
    private Integer duration;
    private String subjectName;
    private String status;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date created;
    private Integer created_by;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date modified;
    private Integer modified_by;
    private String createdByFullName;
    private String modifiedByFullName;
}
