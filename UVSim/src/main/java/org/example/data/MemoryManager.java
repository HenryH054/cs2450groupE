package org.example.data;
import org.example.ui.UVSimGUI;
import java.util.List;

public class MemoryManager {
    private UVSimGUI uvSimGUI;
    private Memory memory;

    /**
     * Manages memory operations, including writing instructions to memory.
     * @author Damon Morgan
     */
    public MemoryManager(UVSimGUI uvSimGUI, Memory memory) {
        this.uvSimGUI = uvSimGUI;
        this.memory = memory;
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
                memory.setData(i, instruction);
            } catch (NumberFormatException e) {
                uvSimGUI.appendMessageToTextArea("Invalid instruction:\n" +
                        instructions.get(i) + " is either too large or an incorrect input\nPlease enter a four digit number.");
            }
        }
    }

    /**
     * Writes the given instructions to memory from a list of integers.
     *
     * @param instructions the list of instructions to write
     */
    public void writeToMemoryFromIntegerList(List<Integer> instructions) {
        for (int i = 0; i < 100 && i < instructions.size(); i++) {
            int instruction = instructions.get(i);
            memory.setData(i, instruction);
        }
    }
}
