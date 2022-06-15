package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder

public class ApiResponse<T> {
    @NotNull
    private Boolean success;
    @NotNull
    private String message;
    private T data;

    public ApiResponse() {

    }
}
