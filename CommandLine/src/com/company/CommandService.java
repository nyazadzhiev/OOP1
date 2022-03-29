package com.company;

public class CommandService {
    private FileEditor fileEditor;
    private Validation validation;

    public CommandService() {
        this.validation = new Validation();
        this.fileEditor = new FileEditor();
    }

    public void executeCommand(String command, String fileData) {
        if(validation.isNullOrEmpty(command) || validation.isNullOrEmpty(fileData)){
            System.out.println("you entered empty string");

            return;
        }

        switch (command) {
            case "open" : fileEditor.open(fileData); break;
            case "close" : fileEditor.close(); break;
            case "save" : fileEditor.save(); break;
            case "saveas" : fileEditor.saveAs(fileData); break;
            case "append" : fileEditor.append(fileData);
            case "exit" : return;
            default:
                System.out.println("Invalid command");
        }
    }
}
