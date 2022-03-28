package com.company;

import java.io.File;
import java.io.IOException;

public class FileEditor {
    private ReadFile read;
    private EditFile edit;
    private SaveFile save;
    private File file;
    private StringBuilder data;

    public FileEditor() {
        this.read = new ReadFile();
        this.edit = new EditFile();
        this.save = new SaveFile();
        this.data = new StringBuilder();
    }

    public void open(String fileData) {
        try {
            this.file = read.openFile(fileData, this.data);

            System.out.println("Successfully opened the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if(this.file != null) {
            this.file = (File) read.closeFile();

            System.out.println("File closed");
        }else{
            System.out.println("Not opened file");
        }
    }

    public void append() {
        edit.append(this.data);
    }

    public void save() {
        save.save(this.file, String.valueOf(this.data));
    }

    public void saveAs(String fileData) {
        save.saveAs(fileData, String.valueOf(this.data));
    }
}
