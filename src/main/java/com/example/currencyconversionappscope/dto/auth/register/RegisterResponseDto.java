package com.example.currencyconversionappscope.dto.auth.register;

import com.example.currencyconversionappscope.constant.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDto {
    private String userName;
    private String email;
    private Role role;
}
