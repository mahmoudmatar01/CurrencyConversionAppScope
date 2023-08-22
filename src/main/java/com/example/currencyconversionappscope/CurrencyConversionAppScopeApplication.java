package com.example.currencyconversionappscope;

import com.example.currencyconversionappscope.exceptions.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConversionAppScopeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionAppScopeApplication.class, args);
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

    }

}
