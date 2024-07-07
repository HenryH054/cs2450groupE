package org.example.business;

import org.example.data.Memory;
import org.example.presentation.UVSimGUI;

/**
 * Handles input and output operations for the UVSim application.
 * @author Damon Morgan
 */
public class IOHandler {
    private Memory memory;
    private UVSimGUI uvSimGUI;

    /**
     * Constructs an IOHandler with the specified memory and GUI.
     *
     * @param memory the memory to interact with
     */
    public IOHandler(Memory memory, UVSimGUI uvSimGUI) {
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
