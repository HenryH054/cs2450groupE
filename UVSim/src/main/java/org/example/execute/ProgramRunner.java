package org.example.execute;

import org.example.business.CPU;
import org.example.file.FileUtil;
import org.example.data.MemoryManager;
import org.example.ui.UVSimGUI;

import java.io.File;
import java.util.List;

/**
 * Manages the execution of programs by interacting with the CPU and memory.
 */
public class ProgramRunner {
   private UVSimGUI uvSimGUI;
   private CPU cpu;
   private MemoryManager memoryManager;

    /**
     * Constructs a ProgramRunner with the specified GUI, CPU, and memory manager.
     *
     * @param uvSimGUI the user interface to display output
     * @param cpu the CPU to execute the program
     * @param memoryManager the memory manager to handle memory operations
     */
   public ProgramRunner(UVSimGUI uvSimGUI, CPU cpu, MemoryManager memoryManager) {
       this.uvSimGUI = uvSimGUI;
       this.cpu = cpu;
       this.memoryManager = memoryManager;
   }

    /**
     * Runs the program. If reRun is true, reloads the program from the specified file.
     *
     * @param reRun whether to reload the program from the file
     * @param selectedFile the file containing the program instructions
     */
    public void runProgram(boolean reRun, File selectedFile) {
        if (reRun) {
            List<Integer> instructions = FileUtil.readFileAsIntegerList(selectedFile);
            memoryManager.writeToMemoryFromIntegerList(instructions);
        }
        cpu.execute();
        uvSimGUI.appendMessageToTextArea("Program executed.\n");
    }
}
