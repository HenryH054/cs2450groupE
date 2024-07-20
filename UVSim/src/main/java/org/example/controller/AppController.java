package org.example.controller;

import org.example.business.IOHandler;
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
    private UVSimGUI uvSimGUI;
    private EditWindow editWindow;
    private CPU cpu;
    private Memory memory;
    private MemoryManager memoryManager;
    private FileManager fileManager;
    private ProgramRunner runner;
    private IOHandler ioHandler;

    /**
     * Initializes the core components of the application.
     */
    public AppController() {
        editWindow = new EditWindow(this);
        uvSimGUI = new UVSimGUI(this, editWindow);
        memory = new Memory();
        ioHandler = new IOHandler(memory, uvSimGUI);
        cpu = new CPU(ioHandler, memory);
        this.memoryManager = new MemoryManager(uvSimGUI, memory);
        this.fileManager = new FileManager(memory, uvSimGUI);
        this.runner = new ProgramRunner(uvSimGUI, cpu, memoryManager);
    }

    /**
     * Returns the GUI component of the application.
     *
     * @return the UVSimGUI instance
     */
    public UVSimGUI getGui() {
        return uvSimGUI;
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
