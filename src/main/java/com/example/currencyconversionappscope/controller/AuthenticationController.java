package com.example.currencyconversionappscope.controller;
import com.example.currencyconversionappscope.dto.auth.login.LoginRequestDto;
import com.example.currencyconversionappscope.dto.auth.login.LoginResponseDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterRequestDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterResponseDto;
import com.example.currencyconversionappscope.services.auth_services.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationServiceImpl authService;

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto) throws Exception{
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) throws UsernameNotFoundException, Exception {
        return ResponseEntity.ok(authService.login(dto));
    }
}
