package main.java.org.example.business;

import org.example.data.Memory;

public class CPU {
    private int programCounter;
    private Memory memory;
    private int accumulator;
    private ArithmeticOperations arithmeticOperations;
    private BranchOperations branchOperations;
    private IOHandler ioHandler;

    public CPU (Memory mem, IOHandler ioHandler){
        this.memory = mem;
        this.arithmeticOperations = new ArithmeticOperations(this);
        this.branchOperations = new BranchOperations(this);
        this.ioHandler = ioHandler;
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

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void execute() {
        Memory memory = this.memory;
        int instruction;
        // Execution loop
        while (programCounter < 100 && programCounter >= 0) { // FC: Loop condition updated to use program counter
            instruction = Math.abs(memory.getData(programCounter));
            int operation = instruction / 100;
            int operand = instruction % 100;

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
                    load(operand);
                    break;
                case 21:
                    //STORE = 21 Store a word from the accumulator into a specific location in memory.
                    store(operand, accumulator);
                    break;
                default:
//                    System.out.println("Invalid instruction: " + instruction);
            }

            boolean isMathOperation = (operation == 30 || operation == 31 || operation == 32 || operation == 33);
            if (isMathOperation) {
                switch(operation) {
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

//            BRANCH = 40 Branch to a specific location in memory
//            BRANCHNEG = 41 Branch to a specific location in memory if the accumulator is negative.
//            BRANCHZERO = 42 Branch to a specific location in memory if the accumulator is zero.
//            HALT = 43 Stop the program
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
    }

    public void reset() {
        accumulator = 0;
        programCounter = 0;
    }

    private void load(int operand) {
        accumulator = memory.getData(operand);
    }

    private void store(int operand, int accumulator) {
        memory.setData(operand, accumulator);
    }

    /*public void add(int operand) {
        accumulator += memory.getData(operand);
    }
    public void subtract(int operand) {
        accumulator -= memory.getData(operand);
    }
    public void divide(int operand) {
        if (memory.getData(operand) != 0) {
            accumulator /= memory.getData(operand);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }
    public void multiply(int operand) {
        accumulator *= memory.getData(operand);
    }*/

    //public void add(int operand) {
    //    accumulator += memory.getData(operand);
    //}
    //public void subtract(int operand) {
    //    accumulator -= memory.getData(operand);
    //}
    //public void divide(int operand) {
    //    if (memory.getData(operand) != 0) {
    //        accumulator /= memory.getData(operand);
    //    } else {
    //        throw new ArithmeticException("Division by zero");
    //    }
    //}
    //public void multiply(int operand) {
    //    accumulator *= memory.getData(operand);
    //}
}

//int instruction;
//// Execution loop
//        while (uvSim.programCounter < 100) { // FC: Loop condition updated to use program counter
//instruction = uvSim.memory[uvSim.programCounter];
//int operation = instruction / 100;
//int operand = instruction % 100;
//
//            switch (operation) {
//        case 10:
//        uvSim.read(operand);
//                    break;
//                            case 11:
//                            uvSim.write(operand);
//                    break;
//                            case 20:
//                            uvSim.load(operand);
//                    break;
//                            case 21:
//                            uvSim.store(operand);
//                    break;
//                            case 30:
//                            uvSim.add(operand);
//                    break;
//                            case 31:
//                            uvSim.subtract(operand);
//                    break;
//                            case 32:
//                            uvSim.divide(operand);
//                    break;
//                            case 33:
//                            uvSim.multiply(operand);
//                    break;
//                            case 40: // FC: BRANCH operation
//                            uvSim.branch(operand);
//                    break;
//                            case 41: // FC: BRANCHNEG operation
//                            uvSim.branchNeg(operand);
//                    break;
//                            case 42: // FC: BRANCHZERO operation
//                            uvSim.branchZero(operand);
//                    break;
//                            case 43: // FC: HALT operation
//                            uvSim.halt();
//                    break;
//default:
//        System.out.println("Invalid instruction: " + instruction);
//            }
//
//boolean isBranchOperation = (operation == 40 || operation == 41 || operation == 42 || operation == 43);
//boolean shouldIncrementPC = true;
//
//            if (isBranchOperation) {
//        if (operation == 40) {
//shouldIncrementPC = false;
//        } else if (operation == 41 && uvSim.accumulator < 0) {
//shouldIncrementPC = false;
//        } else if (operation == 42 && uvSim.accumulator == 0) {
//shouldIncrementPC = false;
//        } else if (operation == 43) {
//shouldIncrementPC = false;
//        }
//        }
//
//        if (shouldIncrementPC) {
//uvSim.programCounter++;
//        }
//
//        // FC: If halted, break the loop
//        if (uvSim.programCounter == -1) {
//        break;
//        }
//        }
