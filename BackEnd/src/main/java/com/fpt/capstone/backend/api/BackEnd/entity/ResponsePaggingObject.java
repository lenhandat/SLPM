package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

@Data
public class ResponsePaggingObject {
    private boolean success;
    private Integer perPages;
    private Integer currentPage;
    private Long total;
    private String message;
    private Object data;


}
