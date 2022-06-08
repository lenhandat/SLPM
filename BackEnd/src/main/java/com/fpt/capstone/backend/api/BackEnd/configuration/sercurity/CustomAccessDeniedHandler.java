package com.fpt.capstone.backend.api.BackEnd.configuration.sercurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ResponseObject responseObject = new ResponseObject();
        if (authentication != null) {
            responseObject.setSuccess(false);
            responseObject.setMessage("Access denied");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(responseObject);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();
    }
}
