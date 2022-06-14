package com.fpt.capstone.backend.api.BackEnd.service;




public enum ConstantsStatus {
    active("ACTIVE"),
    inactive("INACTIVE");

    private final String text;
    ConstantsStatus(String s) {
        text=s;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
