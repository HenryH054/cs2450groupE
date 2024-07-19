package org.example.presentation;

import org.example.business.CPU;

import java.util.List;

public class AppController {
    private UVSimGUI uvSimGUI;
    private CPU cpu;

    public AppController(UVSimGUI uvSimGUI, CPU cpu) {
        this.uvSimGUI = uvSimGUI;
        this.cpu = cpu;
    }

    /**
     * Writes the given instructions to memory from a list of Strings..
     *
     * @param instructions the list of instructions to write
     */
    public void writeToMemoryFromStringList(List<String> instructions) {
        for (int i = 0; i < 100 && i < instructions.size(); i++) {
            try {
                int instruction = Integer.parseInt(instructions.get(i));
                cpu.getMemory().setData(i, instruction);
            } catch (NumberFormatException e) {
                uvSimGUI.appendOutput("Invalid instruction:\n" +
                        instructions.get(i) + " is either too large or an incorrect input\nPlease enter a four digit number.");
            }
        }
    }
}
