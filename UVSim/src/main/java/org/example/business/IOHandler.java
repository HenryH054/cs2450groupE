package main.java.org.example.business;

import main.java.org.example.controller.UVSimGUI;

public class IOHandler {
    org.example.data.Memory memory;
    UVSimGUI uvSimGUI;

    public IOHandler(org.example.data.Memory memory, UVSimGUI uvSimGUI) {
        this.memory = memory;
        this.uvSimGUI = uvSimGUI;
    }

    public void read(int index) {
        int digit = uvSimGUI.getInputField();
        memory.setData(index, digit);
    }

    public void write(int index) {
        uvSimGUI.appendOutput(String.valueOf(memory.getData(index)));
    }
}
