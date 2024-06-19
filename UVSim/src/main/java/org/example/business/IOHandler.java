package main.java.org.example.business;

import main.java.org.example.controller.UVSimGUI;

public class IOHandler {
    org.example.data.Memory memory;
    UVSimGUI uvSimGUI;

    public IOHandler(org.example.data.Memory memory, UVSimGUI uvSimGUI) {
        this.memory = memory;
        this.uvSimGUI = uvSimGUI;
    }

     //I/O methods
    public void read(int index) {
        System.out.println("Enter a four digit number");
        memory.setData(index, 3);
    }

    public void write(int index) {
        System.out.println(memory.getData(index));
    }
}
