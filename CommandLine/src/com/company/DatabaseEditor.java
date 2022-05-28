package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseEditor extends FileEditor{
    private StringBuilder tables;
    private File catalog;
    public DatabaseEditor() {
        this.tables = new StringBuilder();

        catalog = new File("catalog.txt");
        try {
            catalog.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(catalog))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                tables.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertTable(String fileName) {
        File file = new File(fileName);
        if(!file.exists()) {
            System.out.println("File doesnt exist");
            return;
        }
        String path = file.getPath();
        Path filePath = Paths.get(path).getFileName();
        String extension = getExtension(filePath.toString());
        String tableName = filePath.toString().replace(extension, "");

        if(!tables.toString().contains(tableName)) {
            tables.append(tableName).append("\n");
        }else {
            System.out.println("Table already exist");

            return;
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.catalog))){
            bw.write("");
            bw.write(tables.toString());

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTables() {
        try(BufferedReader br = new BufferedReader(new FileReader(catalog))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void renameTable(String name) {
        String[] names = name.split(" ");
        if(this.tables.toString().contains(names[1])) {
            System.out.println("Name already taken");

            return;
        }

        this.tables.setLength(0);

        File file = new File(names[0]+".txt");
        file.renameTo(new File(names[1]+".txt"));

        try(BufferedReader br = new BufferedReader(new FileReader(catalog))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                tables.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newData = tables.toString().replace(names[0], names[1]);

        this.tables.setLength(0);

        this.tables.append(newData);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.catalog))){
            bw.write("");
            bw.write(tables.toString());

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        String extension = null;
        if (index > 0) {
            extension = fileName.substring(index);
        }

        return extension;
    }
}
