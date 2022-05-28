package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CommandService commandService = new CommandService();
        String command;

        do {
            command = input.nextLine();
            String[] commands = command.split(" ", 2);
            commandService.executeCommand(commands[0], commands.length > 1 ? commands[1] : "1");
        }while(!command.equals("exit"));
    }
}
