package org.example;

import org.example.business.IOHandler;
import org.example.presentation.UVSimGUI;
import org.example.data.Memory;
import org.example.business.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TestNameLoggingExtension.class)
public class BranchOperationsTest {
    private CPU cpu;

    @BeforeEach
    public void setUp() {
        UVSimGUI gui = new UVSimGUI();
        Memory mem = new Memory();
        IOHandler io = new IOHandler(mem, gui);
        cpu = new CPU(gui);
    }

    @Test
    public void branch() {
        Memory mem = new Memory();
        mem.setData(0, 4010);
        mem.setData(5, 9999);
        mem.setData(4, 2005);
        mem.setData(10, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.execute();
        assert(cpu.getAccumulator() != 9999);
    }
    @Test
    public void branchNeg() {
        Memory mem = new Memory();
        mem.setData(0, 4110);
        mem.setData(5, 9999);
        mem.setData(4, 2005);
        mem.setData(10, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(-1);
        cpu.execute();
        assert(cpu.getAccumulator() != 9999);
    }
    @Test
    public void branchNegFalse() {
        Memory mem = new Memory();
        mem.setData(0, 4110);
        mem.setData(5, 9999);
        mem.setData(4, 2005);
        mem.setData(10, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(0);
        cpu.execute();
        assert(cpu.getAccumulator() == 9999);
    }
    @Test
    public void branchZero() {
        Memory mem = new Memory();
        mem.setData(0, 4210);
        mem.setData(5, 9999);
        mem.setData(4, 2005);
        mem.setData(10, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(0);
        cpu.execute();
        assert(cpu.getAccumulator() != 9999);
    }
    @Test
    public void branchZeroFalse() {
        Memory mem = new Memory();
        mem.setData(0, 4210);
        mem.setData(5, 9999);
        mem.setData(4, 2005);
        mem.setData(10, 4300);
        cpu.setMemory(mem);
        cpu.setProgramCounter(1);
        cpu.execute();
        assert(cpu.getAccumulator() == 9999);
    }
}