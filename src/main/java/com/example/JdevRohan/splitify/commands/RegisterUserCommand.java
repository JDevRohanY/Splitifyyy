package com.example.JdevRohan.splitify.commands;

import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
