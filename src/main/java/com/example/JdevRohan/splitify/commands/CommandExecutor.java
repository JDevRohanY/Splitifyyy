package com.example.JdevRohan.splitify.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private AddMemberCommand addMemberCommand;
    private AddGroupCommand addGroupCommand;
    private SettleUpUserCommand settleUpUserCommand;
    private RegisterUserCommand registerUserCommand;

    private static List<Command> commands = new ArrayList<>();

    public CommandExecutor(AddMemberCommand addMemberCommand,
                           AddGroupCommand addGroupCommand,
                           SettleUpUserCommand settleUpUserCommand,
                           RegisterUserCommand registerUserCommand) {
        this.addMemberCommand = addMemberCommand;
        this.addGroupCommand = addGroupCommand;
        this.settleUpUserCommand = settleUpUserCommand;
        this.registerUserCommand = registerUserCommand;

        commands.add(addMemberCommand);
        commands.add(addGroupCommand);
        commands.add(settleUpUserCommand);
        commands.add(registerUserCommand);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(
                command
        );
    }

    public static void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                System.out.println("Executing..." + command);
                command.execute(input);
                break;
            }
        }
    }

}
