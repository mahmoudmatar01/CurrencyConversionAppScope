package com.example.currencyconversionappscope.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ResponseEntity<ErrorResponse>handleCourseNotFoundException(final NotFoundException courseException){
        ErrorResponse errorResponse=new ErrorResponse("404",courseException.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GlobalExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse>handleCourseGlobalException(final GlobalExceptionClass courseException){
        ErrorResponse errorResponse=new ErrorResponse(courseException.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
