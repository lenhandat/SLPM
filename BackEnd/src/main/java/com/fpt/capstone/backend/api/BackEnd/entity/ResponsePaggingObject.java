package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

@Data
public class ResponsePaggingObject {
    private String success;
    private Integer totalPages;
    private Integer currentPage;
    private Long totalItems;
    private String message;
    private Object data;


}
