package com.example.currencyconversionappscope.dto.auth.login;

import com.example.currencyconversionappscope.constant.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private String userName;
    private String email;
    private Role role;
    private boolean isAuthenticated;
    private String token;
}
