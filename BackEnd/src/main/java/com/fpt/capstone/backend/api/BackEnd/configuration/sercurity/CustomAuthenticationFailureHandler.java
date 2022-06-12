package com.fpt.capstone.backend.api.BackEnd.configuration.sercurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(false);
        responseObject.setMessage("Login fail: invalid username or password");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(responseObject);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();
//        String json = new Gson().toJson(someObject);
//        response.getWriter().write(responseObject);
//                .(objectMapper.writeValueAsString(responseObject));

    }
}
