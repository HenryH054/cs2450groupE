package org.example.business;
import org.example.data.Memory;
import org.example.ui.UVSimGUI;


public class CPU {
    private int programCounter;
    private Memory memory;
    private int accumulator;
    private ArithmeticOperations arithmeticOperations;
    private BranchOperations branchOperations;
    private IOHandler ioHandler;
    private LoadStoreOperations loadStoreOperations;

    public CPU(UVSimGUI gui, Memory memory) {
        this.memory = memory;
        this.arithmeticOperations = new ArithmeticOperations(memory, this);
        this.branchOperations = new BranchOperations(this);
        this.ioHandler = new IOHandler(memory, gui);
        loadStoreOperations = new LoadStoreOperations(this, memory);
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public void execute() {
        Memory memory = this.memory;
        int instruction;

        while (programCounter < Memory.SIZE && programCounter >= 0) { // FC: Loop condition updated to use program counter
            instruction = Math.abs(memory.getData(programCounter));
            int operation = instruction / 1000;
            int operand = instruction % 100;
            System.out.println("Instruction: " + instruction + " Operation: " + operation + " Operand: " + operand);
            switch (operation) {
                case 10:
                    //READ = 10 Read a word from the keyboard into a specific location in memory.
                    ioHandler.read(operand);
                    break;
                case 11:
                    //WRITE = 11 Write a word from a specific location in memory to screen.
                    ioHandler.write(operand);
                    break;
                case 20:
                    //LOAD = 20 Load a word from a specific location in memory into the accumulator.
                    loadStoreOperations.load(operand);
                    break;
                case 21:
                    //STORE = 21 Store a word from the accumulator into a specific location in memory.
                    loadStoreOperations.store(operand, accumulator);
                    break;
            }

            boolean isMathOperation = (operation == 30 || operation == 31 || operation == 32 || operation == 33);
            if (isMathOperation) {
                switch (operation) {
                    case 30:
                        arithmeticOperations.add(operand);
                        break;
                    case 31:
                        arithmeticOperations.subtract(operand);
                        break;
                    case 32:
                        arithmeticOperations.divide(operand);
                        break;
                    case 33:
                        arithmeticOperations.multiply(operand);
                        break;
                }
            }

            boolean isBranchOperation = (operation == 40 || operation == 41 || operation == 42 || operation == 43);
            boolean shouldIncrementPC = true;

            if (isBranchOperation) {
                if (operation == 40) {
                    branchOperations.branch(operand);
                    shouldIncrementPC = false;
                } else if (operation == 41 && accumulator < 0) {
                    branchOperations.branchNeg(operand);
                    shouldIncrementPC = false;
                } else if (operation == 42 && accumulator == 0) {
                    branchOperations.branchZero(operand);
                    shouldIncrementPC = false;
                } else if (operation == 43) {
                    branchOperations.halt();
                    shouldIncrementPC = false;
                }
            }

            if (shouldIncrementPC) {
                programCounter++;
            }

            // FC: If halted, break the loop
            if (programCounter == -1) {
                break;
            }
        }
        reset();
    }

    public void reset() {
        memory.clear();
        accumulator = 0;
        programCounter = 0;
    }
}