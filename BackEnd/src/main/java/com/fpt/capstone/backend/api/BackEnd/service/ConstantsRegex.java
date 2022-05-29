package com.fpt.capstone.backend.api.BackEnd.service;

public enum ConstantsRegex {
//    validateDate
//    String regex = "^[a-zA-Z]+$";
//    validatePhone
//    String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
//    validateString
//    String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\+\\d{4}";

    email("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"),
    pass("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
    private final String text;
     ConstantsRegex(String s) {
        text=s;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
