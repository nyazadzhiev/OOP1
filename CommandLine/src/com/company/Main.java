package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CommandService commandService = new CommandService();
        String command;

        do {
            command = input.nextLine();
            commandService.executeCommand(command, "file.xml");
        }while(!command.equals("exit"));
    }
}
