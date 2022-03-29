package com.company;

import java.io.File;

public class Validation {
    public Validation() {
    }

    public boolean isFileOpened(File file) {
        if(file != null)
            return true;

        return false;
    }
}
