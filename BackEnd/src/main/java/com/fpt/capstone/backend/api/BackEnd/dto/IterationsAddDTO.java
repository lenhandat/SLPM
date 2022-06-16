package com.fpt.capstone.backend.api.BackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IterationsAddDTO {
    private Integer id;
    private Integer subjectId;
    private String name;
    private Integer duration;
    private String status;
}
