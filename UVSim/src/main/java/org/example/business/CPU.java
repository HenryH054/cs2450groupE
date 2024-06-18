package main.java.org.example.business;

import main.java.org.example.data.Memory;

import java.util.Scanner;

public class CPU {
    private Memory memory;
    private int programCounter;
    private Scanner inputScanner = new Scanner(System.in);
    private int accumulator;


    private void execute() {
        int instruction;
        // Execution loop
        while (programCounter < 100) { // FC: Loop condition updated to use program counter
            instruction = memory.getData(programCounter);
            int operation = instruction / 100;
            int operand = instruction % 100;

            switch (operation) {
                case 10:
                    memory.read(operand, inputScanner);
                    break;
                case 11:
                    memory.write(operand);
                    break;
                case 20:
                    accumulator = memory.getData(operand);
                    break;
                case 21:
                    memory.setData(operand, accumulator);
                    break;
                case 30:
                    uvSim.add(operand);
                    break;
                case 31:
                    uvSim.subtract(operand);
                    break;
                case 32:
                    uvSim.divide(operand);
                    break;
                case 33:
                    uvSim.multiply(operand);
                    break;
                case 40: // FC: BRANCH operation
                    uvSim.branch(operand);
                    break;
                case 41: // FC: BRANCHNEG operation
                    uvSim.branchNeg(operand);
                    break;
                case 42: // FC: BRANCHZERO operation
                    uvSim.branchZero(operand);
                    break;
                case 43: // FC: HALT operation
                    uvSim.halt();
                    break;
                default:
                    System.out.println("Invalid instruction: " + instruction);
            }

            boolean isBranchOperation = (operation == 40 || operation == 41 || operation == 42 || operation == 43);
            boolean shouldIncrementPC = true;

            if (isBranchOperation) {
                if (operation == 40) {
                    shouldIncrementPC = false;
                } else if (operation == 41 && uvSim.accumulator < 0) {
                    shouldIncrementPC = false;
                } else if (operation == 42 && uvSim.accumulator == 0) {
                    shouldIncrementPC = false;
                } else if (operation == 43) {
                    shouldIncrementPC = false;
                }
            }

            if (shouldIncrementPC) {
                uvSim.programCounter++;
            }

            // FC: If halted, break the loop
            if (uvSim.programCounter == -1) {
                break;
            }
        }
    }
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
