package com.fpt.capstone.backend.api.BackEnd.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HelloController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //@Secured({"ADMIN"})
    @RequestMapping({ "/hello1" })
    public String firstPage1() {
    	UserDetails u = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello World" + u.getUsername() + " " + u.getAuthorities();
    }

}
