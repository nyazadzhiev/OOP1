package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileEditor fileEditor = new FileEditor();

        fileEditor.open("file.xml");
        fileEditor.open("file.xml");
        fileEditor.close();
        fileEditor.close();
        fileEditor.append();
        String path = "D:" + File.separator + "Test" + File.separator + "test.txt";
        fileEditor.saveAs(path);
        fileEditor.close();
        fileEditor.open(path);
        fileEditor.append();
        fileEditor.saveAs(path);
    }
}
