package main.java.org.example.business;

import main.java.org.example.controller.UVSimGUI;

/**
 * Handles input and output operations for the UVSim application.
 * @author Damon Morgan
 */
public class IOHandler {
    org.example.data.Memory memory;
    UVSimGUI uvSimGUI;

    /**
     * Constructs an IOHandler with the specified memory and GUI.
     *
     * @param memory the memory to interact with
     * @param uvSimGUI the GUI to interact with
     */
    public IOHandler(org.example.data.Memory memory, UVSimGUI uvSimGUI) {
        this.memory = memory;
        this.uvSimGUI = uvSimGUI;
    }

    /**
     * Reads an integer from the user and stores it in memory at the specified index.
     *
     * @param index the index in memory to store the integer
     */
    public void read(int index) {
        int digit = uvSimGUI.getInputField();
        memory.setData(index, digit);
    }

    /**
     * Writes the data from the specified index in memory to the GUI output area.
     *
     * @param index the index in memory to read the data from
     */
    public void write(int index) {
        uvSimGUI.appendOutput(String.valueOf(memory.getData(index)));
    }
}
