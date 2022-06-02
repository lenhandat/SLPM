package com.fpt.capstone.backend.api.BackEnd.service.validate;

public enum ConstantsRegex {
    //    validateDate
//    String regex = "^[a-zA-Z]+$";
//    String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
//    validateString
    nameValidate("^[a-zA-Z\\s]+"),
    numberValidate("^\\d+$"),
    phoneValidate("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}"),
    emailValidate("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"),
    passValidate("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
    private final String text;

    ConstantsRegex(String s) {
        text = s;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
