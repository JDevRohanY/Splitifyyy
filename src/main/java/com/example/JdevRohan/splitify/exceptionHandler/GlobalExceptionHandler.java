package com.example.JdevRohan.splitify.exceptionHandler;

import com.example.JdevRohan.splitify.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handerUserNotFoundException(){
        return "User not found, Please enter correct userId.";
    }
}
