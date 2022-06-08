package com.fpt.capstone.backend.api.BackEnd.configuration.sercurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * This class will extend Spring's AuthenticationEntryPoint class and override its method commence.
 * It rejects every unauthenticated request and send error code 401
 */

@Component
public class JwtAuthenticationEntryPoint implements  AuthenticationEntryPoint , Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {


        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(false);
        responseObject.setMessage("Login fail wrong username or password");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(responseObject);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();


    }
}