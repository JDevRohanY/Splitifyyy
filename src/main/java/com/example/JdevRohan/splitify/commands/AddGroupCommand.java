package com.example.JdevRohan.splitify.commands;

import org.springframework.stereotype.Component;

@Component
public class AddGroupCommand implements Command{
    /*u1 AddGroup Roommates
       u1 is creating a group titled "Roommates"
    */
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }


}
