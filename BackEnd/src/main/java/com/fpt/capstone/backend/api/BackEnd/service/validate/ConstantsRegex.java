package com.fpt.capstone.backend.api.BackEnd.service.validate;

public enum ConstantsRegex {
    USERNAME_PATTERN("^[a-z0-9._-]{5,20}$"),
    NAME_PATTERN("^[a-zA-Z\\s]+"),
    STATUS_PATTERN("^(?i)(active|inactive)$"),
    NUMBER_PATTERN("^\\d+$"),
    PHONE_PATTERN("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}"),
    EMAIL_PATTERN("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"),
    CODE_PATTERN("^[a-zA-Z0-9._-]{3,50}$"),
    PASSWORD_PATTERN("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
    private final String text;

    ConstantsRegex(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
