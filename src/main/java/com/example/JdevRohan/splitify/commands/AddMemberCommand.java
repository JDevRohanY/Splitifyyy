package com.example.JdevRohan.splitify.commands;

import com.example.JdevRohan.splitify.controllers.UserController;
import com.example.JdevRohan.splitify.dtos.AddMemberRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMemberCommand implements Command {
    private final CommandKeywords commandKeywords;
    private final UserController userController;

    public AddMemberCommand(CommandKeywords commandKeywords, UserController userController) {
        this.commandKeywords = commandKeywords;
        this.userController = userController;
    }

    /*
    u1 AddMember g1 u2
        u1 is adding u2 as a member of the group "Roommates" (which has the id g1)
     */
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(1).equals(commandKeywords.AddMemberCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long admin = Long.valueOf(words.get(0));
        Long groupId = Long.valueOf(words.get(2));
        Long userId = Long.valueOf(words.get(3));

        AddMemberRequestDto requestDto = new AddMemberRequestDto();
        requestDto.setAdminId(admin);
        requestDto.setUserId(userId);
        requestDto.setGroupId(groupId);

        userController.addMember(requestDto);
    }
}
