package com.example.currencyconversionappscope.services.auth_services;

import com.example.currencyconversionappscope.dto.auth.login.LoginRequestDto;
import com.example.currencyconversionappscope.dto.auth.login.LoginResponseDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterRequestDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterResponseDto;

import java.sql.SQLIntegrityConstraintViolationException;

public interface IBaseAuthenticationService {
     RegisterResponseDto register(RegisterRequestDto dto) throws SQLIntegrityConstraintViolationException;
     LoginResponseDto login(LoginRequestDto dto) throws Exception;
}
