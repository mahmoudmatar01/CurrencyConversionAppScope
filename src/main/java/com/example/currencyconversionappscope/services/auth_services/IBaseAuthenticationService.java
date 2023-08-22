package com.example.currencyconversionappscope.services.auth_services;

import com.example.currencyconversionappscope.dto.auth.login.LoginRequestDto;
import com.example.currencyconversionappscope.dto.auth.login.LoginResponseDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterRequestDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterResponseDto;
import com.example.currencyconversionappscope.exceptions.GlobalExceptionClass;

import java.sql.SQLIntegrityConstraintViolationException;

public interface IBaseAuthenticationService {
     RegisterResponseDto register(RegisterRequestDto dto) throws GlobalExceptionClass;
     LoginResponseDto login(LoginRequestDto dto) throws Exception;
}
