package com.company;

public class CommandService {
    private FileEditor fileEditor;
    private DatabaseEditor baseEditor;
    private Validation validation;

    public CommandService() {
        this.validation = new Validation();
        this.baseEditor = new DatabaseEditor();
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
            case "append" : fileEditor.append(fileData); break;
            case "help": fileEditor.help(); break;
            case "import" : baseEditor.insertTable(fileData); break;
            case "showtables" : baseEditor.showTables(); break;
            case "rename" : baseEditor.renameTable(fileData); break;
            case "exit" :
                System.out.println("Exiting the program ..."); return;
            default:
                System.out.println("Invalid command");
        }
    }
}
