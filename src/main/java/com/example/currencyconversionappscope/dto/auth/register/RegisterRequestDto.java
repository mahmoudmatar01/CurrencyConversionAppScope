package com.example.currencyconversionappscope.dto.auth.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String userNameOrEmail;
    private String password;
}
