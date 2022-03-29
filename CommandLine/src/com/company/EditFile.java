package com.company;

import java.util.Scanner;

public class EditFile {
    public EditFile() {
    }

    public void append(StringBuilder data) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter value to append\n");
        if(input.hasNextLine()) {
            String value = input.nextLine();
            data.append(value);
        }
    }
}
