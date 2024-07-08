package org.example;

import org.example.business.IOHandler;
import org.example.presentation.UVSimGUI;
import org.example.data.Memory;
import org.example.business.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TestNameLoggingExtension.class)
public class CPUTest {
    private CPU cpu;

    @BeforeEach
    public void setUp() {
        UVSimGUI gui = new UVSimGUI();
        Memory mem = new Memory();
        IOHandler io = new IOHandler(mem, gui);
        cpu = new CPU(gui);
    }

    @Test
    public void create_cpu() {
        assert(this.cpu != null);
    }

    @Test
    public void getAndSetProgramCounter() {
        int x = 15;
        cpu.setProgramCounter(x);
        assert(cpu.getProgramCounter() == x);
    }

    @Test
    public void  getAndSetAccumulator() {
        int x = 15;
        cpu.setAccumulator(x);
        assert(cpu.getAccumulator() == x);

    }

    @Test
    public void getAndSetMemory() {
        Memory mem = new Memory();
        cpu.setMemory(mem);
        assert(cpu.getMemory() == mem);
    }

    @Test
    public void execute() {
        // Tests that the execute class functions appropriately by loading a value from memory.
        Memory mem = new Memory();
        mem.setData(0, 2001);
        mem.setData(1, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.execute();
        assert(cpu.getAccumulator() == 4300);
        }

        @Test
    public void reset() {
        cpu.setAccumulator(10);
        cpu.setProgramCounter(10);
        cpu.reset();
        assert(cpu.getAccumulator() == 0 && cpu.getProgramCounter() == 0);
        }
}


