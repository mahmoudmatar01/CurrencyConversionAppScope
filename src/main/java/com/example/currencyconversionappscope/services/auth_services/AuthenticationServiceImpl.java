package com.example.currencyconversionappscope.services.auth_services;

import com.example.currencyconversionappscope.constant.enums.Role;
import com.example.currencyconversionappscope.dto.auth.login.LoginRequestDto;
import com.example.currencyconversionappscope.dto.auth.login.LoginResponseDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterRequestDto;
import com.example.currencyconversionappscope.dto.auth.register.RegisterResponseDto;
import com.example.currencyconversionappscope.entity.User;
import com.example.currencyconversionappscope.repository.UserRepository;
import com.example.currencyconversionappscope.securityconfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IBaseAuthenticationService{

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto dto) throws SQLIntegrityConstraintViolationException {
        var user = User
                .builder()
                .userName(dto.getUserNameOrEmail())
                .email(dto.getUserNameOrEmail())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        try {
            User savedUser = repository.save(user);
            return RegisterResponseDto
                    .builder()
                    .email(savedUser.getEmail())
                    .userName(savedUser.getUsername())
                    .role(savedUser.getRole())
                    .build();
        } catch (Exception e) {
            System.out.println("Caught Exception");
// todo:add exception here
            return null;
        }
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getUserNameOrEmail(),
                            dto.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new Exception("There is no authenticated user with that credentials");
        }

        var user = repository.findUserByUserName(dto.getUserNameOrEmail())
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with that email."));
        Map<String, Object> claims = Map.of("userId", user.getId(), "email", user.getEmail());
        var token = jwtService.generateToken(claims, user);
        return LoginResponseDto.builder()
                .isAuthenticated(true)
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }
    }

