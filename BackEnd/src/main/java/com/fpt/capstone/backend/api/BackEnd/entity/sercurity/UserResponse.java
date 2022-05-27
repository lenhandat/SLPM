package com.fpt.capstone.backend.api.BackEnd.entity.sercurity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private long id;

    private String username;

    private String role;


}
