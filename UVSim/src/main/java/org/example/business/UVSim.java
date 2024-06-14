package main.java.org.example.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVSim {
    public int[] memory = new int[100];
    public int accumulator = 0;
    public int programCounter = 0; // FC: Added program counter
    public static Scanner inputScanner = new Scanner(System.in); // Create the Scanner for user input

    public static void main(String[] args) throws FileNotFoundException {
        UVSim uvSim = new UVSim();

        int instruction;

        File file = new File("/Users/dj/Documents/GitHub/cs2450groupE/UVSim/src/main/java/Test2.txt");

        Scanner scannerFile = new Scanner(file);

        // Read all instructions into memory
        for (int i = 0; i < 100 && scannerFile.hasNextLine(); i++) {
            uvSim.memory[i] = scannerFile.nextInt();
        }
        scannerFile.close(); // FC: Closing the file scanner

        // Execution loop
        while (uvSim.programCounter < 100) { // FC: Loop condition updated to use program counter
            instruction = uvSim.memory[uvSim.programCounter];
            int operation = instruction / 100;
            int operand = instruction % 100;

            switch (operation) {
                case 10:
                    uvSim.read(operand);
                    break;
                case 11:
                    uvSim.write(operand);
                    break;
                case 20:
                    uvSim.load(operand);
                    break;
                case 21:
                    uvSim.store(operand);
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
        inputScanner.close();
    }

    private static int truncateToFourDigits(int number) {
        // Convert the number to a string
        String numStr = String.valueOf(Math.abs(number));
        String sign = number < 0 ? "-" : "";

        // If the number has more than four digits, get the first four digits
        if (numStr.length() > 4) {
            numStr = numStr.substring(0, 4);
        }

        // Convert back to an integer and return
        return Integer.parseInt(sign + numStr);
    }


    // I/O methods
    public void read(int operand) {
        System.out.println("Enter a four digit number");
        memory[operand] = truncateToFourDigits(inputScanner.nextInt());;
    }

    public void write(int operand) {
        System.out.println(memory[operand]);
    }

    // Load/Store methods
    public void load(int operand) {
        accumulator = memory[operand];
    }

    public void store(int operand) {
        memory[operand] = truncateToFourDigits(accumulator);
    }

    // Arithmetic methods
    public void add(int operand) {
        accumulator += memory[operand];
    }

    public void subtract(int operand) {
        accumulator -= memory[operand];
    }

    public void divide(int operand) {
        if (memory[operand] != 0) {
            accumulator /= memory[operand];
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        accumulator *= memory[operand];
    }

    // FC: Control operation methods
    public void branch(int operand) {
        programCounter = operand; // FC: Set program counter to operand
    }

    public void branchNeg(int operand) {
        if (accumulator < 0) {
            programCounter = operand; // FC: Set program counter to operand if accumulator is negative
        }
    }

    public void branchZero(int operand) {
        if (accumulator == 0) {
            programCounter = operand; // FC: Set program counter to operand if accumulator is zero
        }
    }

    public void halt() {
        System.out.println("Program execution halted.");
        programCounter = -1; // FC: Set program counter to -1 to indicate halt
    }
}
