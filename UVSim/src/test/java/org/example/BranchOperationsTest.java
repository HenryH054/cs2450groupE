package org.example;

import org.example.business.IOHandler;
import org.example.ui.UVSimGUI;
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
        Memory mem = new Memory();
        IOHandler io = new IOHandler(mem, null);
        cpu = new CPU(null, mem);
    }

    @Test
    public void branch() {
        Memory mem = new Memory();
        mem.setData(0, 40010);
        mem.setData(5, 99099);
        mem.setData(4, 20005);
        mem.setData(10, 43000);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.execute();
        assert(cpu.getAccumulator() != 99099);
    }
    @Test
    public void branchNeg() {
        Memory mem = new Memory();
        mem.setData(0, 41010);
        mem.setData(5, 99099);
        mem.setData(4, 20005);
        mem.setData(10, 43000);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(-1);
        cpu.execute();
        assert(cpu.getAccumulator() != 99099);
    }
    @Test
    public void branchNegFalse() {
        Memory mem = new Memory();
        mem.setData(0, 42009);
        mem.setData(5, 99099);
        mem.setData(4, 20005);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(10);
        cpu.setMemory(mem);
        cpu.execute();
        assert(cpu.getAccumulator() == 99099);
    }
    @Test
    public void branchZero() {
        Memory mem = new Memory();
        mem.setData(0, 42010);
        mem.setData(5, 99099);
        mem.setData(4, 20005);
        mem.setData(10, 43000);
        cpu.setMemory(mem);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(0);
        cpu.execute();
        assert(cpu.getAccumulator() != 99099);
    }
    @Test
    public void branchZeroFalse() {
        Memory mem = new Memory();
        mem.setData(0, 42009);
        mem.setData(5, 99099);
        mem.setData(4, 20005);
        cpu.setProgramCounter(0);
        cpu.setAccumulator(10);
        cpu.setMemory(mem);
        cpu.execute();
        System.out.println(cpu.getAccumulator());
        assert(cpu.getAccumulator() == 99099);
    }
}