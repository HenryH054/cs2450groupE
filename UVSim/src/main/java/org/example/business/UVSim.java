package main.java.org.example.business;

import main.java.org.example.controller.UVSimGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVSim {
    public int[] memory = new int[100];
    public int accumulator = 0;
    public int programCounter = 0; // FC: Added program counter
    public Scanner inputScanner = new Scanner(System.in); // Create the Scanner for user input

    public static void main(String[] args) {
        UVSimGUI gui = new UVSimGUI();
        gui.createAndShowGUI();
    }

//    private void guts() throws FileNotFoundException {
//        UVSim uvSim = new UVSim();
//
//        int instruction;
//
//        File file = new File("/Users/dj/Documents/GitHub/cs2450groupE/UVSim/src/main/java/Test2.txt");
//
//        Scanner scannerFile = new Scanner(file);
//
//        // Read all instructions into memory
//        for (int i = 0; i < 100 && scannerFile.hasNextLine(); i++) {
//            uvSim.memory[i] = scannerFile.nextInt();
//        }
//        scannerFile.close(); // FC: Closing the file scanner
//
//
//        execute(uvSim);
//    }



//
//    // I/O methods
//    public void read(int operand) {
//        System.out.println("Enter a four digit number");
//        memory[operand] = truncateToFourDigits(inputScanner.nextInt());;
//    }
//
//    public void write(int operand) {
//        System.out.println(memory[operand]);
//    }
//
//    // Load/Store methods
//    public void load(int operand) {
//        accumulator = memory[operand];
//    }
//
//    public void store(int operand) {
//        memory[operand] = truncateToFourDigits(accumulator);
//    }

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
