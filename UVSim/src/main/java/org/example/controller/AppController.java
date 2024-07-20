package org.example.controller;

import org.example.file.FileManager;
import org.example.business.CPU;
import org.example.data.Memory;
import org.example.data.MemoryManager;
import org.example.presentation.EditWindow;
import org.example.presentation.UVSimGUI;

public class AppController {
    private UVSimGUI uvSimGUI;
    private EditWindow editWindow;
    private CPU cpu;
    private Memory memory;
    private MemoryManager memoryManager;
    private FileManager fileManager;
    private ProgramRunner runner;

    public AppController() {
        editWindow = new EditWindow(this);
        uvSimGUI = new UVSimGUI(this, editWindow);
        memory = new Memory();
        cpu = new CPU(uvSimGUI, memory);
        this.memoryManager = new MemoryManager(uvSimGUI, memory);
        this.fileManager = new FileManager(memory, uvSimGUI);
        this.runner = new ProgramRunner(uvSimGUI, cpu, memoryManager);
    }

    public UVSimGUI getGui() {
        return uvSimGUI;
    }

    public MemoryManager getMemoryManager() {
        return memoryManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public ProgramRunner getRunner() {
        return runner;
    }
}
