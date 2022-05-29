package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

@Data
public class ResponsePaggingObject {
    private String success;
    private String message;
    private Object data;
    private Integer total;
}
