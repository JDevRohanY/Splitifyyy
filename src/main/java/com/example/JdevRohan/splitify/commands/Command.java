package com.example.JdevRohan.splitify.commands;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
