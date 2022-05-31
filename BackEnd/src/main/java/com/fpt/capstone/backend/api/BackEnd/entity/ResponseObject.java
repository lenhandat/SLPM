package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

@Data
public class ResponseObject {
    private String success;
    private String message;
    private Object data;
}
