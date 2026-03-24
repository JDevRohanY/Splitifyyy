package com.example.JdevRohan.splitify.controllers;

import com.example.JdevRohan.splitify.dtos.AddMemberRequestDto;
import com.example.JdevRohan.splitify.dtos.RegisterUserRequestDto;
import com.example.JdevRohan.splitify.dtos.RegisterUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    public RegisterUserResponseDto addMember(RegisterUserRequestDto requestDto){
        System.out.println("Register user command");
        return null;
    }

    public ResponseEntity<Void> addMember(AddMemberRequestDto requestDto) {
        return null;
    }
}
