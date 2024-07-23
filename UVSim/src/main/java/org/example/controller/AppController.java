package org.example.controller;

import org.example.execute.ProgramRunner;
import org.example.file.FileManager;
import org.example.business.CPU;
import org.example.data.Memory;
import org.example.data.MemoryManager;
import org.example.ui.EditWindow;
import org.example.ui.UVSimGUI;

/**
 * Manages the application components and their interactions.
 * Responsible for initializing and providing access to core components.
 * @author Damon Morgan
 */
public class AppController {
    private UVSimGUI gui;
    private CPU cpu;
    private Memory memory;
    private MemoryManager memoryManager;
    private FileManager fileManager;
    private ProgramRunner runner;

    /**
     * Initializes the core components of the application.
     */
    public AppController() {
        gui = new UVSimGUI(this);
        memory = new Memory();
        cpu = new CPU(gui, memory);
        this.memoryManager = new MemoryManager(gui, memory);
        this.fileManager = new FileManager(memory, gui);
        this.runner = new ProgramRunner(gui, cpu, memoryManager);
    }

    /**
     * Returns the GUI component of the application.
     *
     * @return the UVSimGUI instance
     */
    public UVSimGUI getGui() {
        return gui;
    }

    /**
     * Returns the memory manager component of the application.
     *
     * @return the MemoryManager instance
     */
    public MemoryManager getMemoryManager() {
        return memoryManager;
    }

    /**
     * Returns the file manager component of the application.
     *
     * @return the FileManager instance
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Returns the program runner component of the application.
     *
     * @return the ProgramRunner instance
     */
    public ProgramRunner getRunner() {
        return runner;
    }

}
