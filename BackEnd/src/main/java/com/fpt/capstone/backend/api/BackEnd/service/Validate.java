package com.fpt.capstone.backend.api.BackEnd.service;

public class Validate {

    public boolean validateEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean validatePassword(String pass){
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        return pass.matches(regex);
    }

    public boolean validateInteger(String integer){
        String regex = ".*[^0-9].*";
        return integer.matches(regex);
    }

    public boolean validateDate(String date){
        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\+\\d{4}";
        return date.matches(regex);
    }

    public boolean validatePhone(String phone){
        String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        return phone.matches(regex);
    }

    public boolean validateString(String str){
        String regex = "^[a-zA-Z]+$";
        return str.matches(regex);
    }



}
