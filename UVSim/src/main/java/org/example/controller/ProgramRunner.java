package org.example.controller;

import org.example.business.CPU;
import org.example.file.FileUtil;
import org.example.data.MemoryManager;
import org.example.presentation.UVSimGUI;

import java.io.File;
import java.util.List;

public class ProgramRunner {
   private UVSimGUI uvSimGUI;
   private CPU cpu;
   private MemoryManager memoryManager;

   public ProgramRunner(UVSimGUI uvSimGUI, CPU cpu, MemoryManager memoryManager) {
       this.uvSimGUI = uvSimGUI;
       this.cpu = cpu;
       this.memoryManager = memoryManager;
   }

    public void runProgram(boolean reRun, File selectedFile) {
        if (reRun) {
            List<Integer> instructions = FileUtil.readFileAsIntegerList(selectedFile);
            memoryManager.writeToMemoryFromIntegerList(instructions);
        }
        cpu.execute();
        uvSimGUI.appendOutput("Program executed.\n");
    }
}
