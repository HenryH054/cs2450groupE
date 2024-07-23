package org.example.business;

import org.example.data.Memory;

/**
 * Handles load and store operations for the CPU.
 */
public class LoadStoreOperations {
    private CPU cpu;
    private Memory memory;

    /**
     * Constructs a LoadStoreOperations instance with the specified CPU and memory.
     *
     * @param cpu the CPU instance
     * @param memory the memory instance
     */
    public LoadStoreOperations(CPU cpu, Memory memory) {
       this.cpu = cpu;
        this.memory = memory;
    }

    /**
     * Loads a word from memory into the CPU accumulator.
     *
     * @param operand the memory address to load from
     */
    public void load(int operand) {
        cpu.setAccumulator(memory.getData(operand));
    }

    /**
     * Stores a word from the CPU accumulator into memory.
     *
     * @param operand the memory address to store to
     * @param accumulator the value to store
     */
    public void store(int operand, int accumulator) {
        memory.setData(operand, accumulator);
    }
}

