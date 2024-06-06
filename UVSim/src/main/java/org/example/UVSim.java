
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UVSim {
    public int[] memory = new int[100];
    public int accumulator = 0;

    public static void main(String[] args) throws FileNotFoundException {
        UVSim uvSim = new UVSim();
        int instruction;

        
        File file = new File(args[0]);

        Scanner scannerFile = new Scanner(file);

        while (scannerFile.hasNextLine()) {
            instruction = scannerFile.nextInt();
            int operation = instruction / 100;
            int operand = instruction % 100;

            switch(operation) {
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
                case 40:
                    // code block
                    break;
                case 41:
                    // code block
                    break;
                case 42:
                    // code block
                    break;
                case 43:
                    // code block
                    break;
                default:
                    // code block
            }
        }
        scannerFile.close();
    }

    public void read(int operand) {
        System.out.println("Enter number:");
        Scanner input = new Scanner(System.in);
        memory[operand] = input.nextInt();
        input.close();
    }

    public void write(int operand) {
        System.out.println(memory[operand]);
    }

    public void load(int operand) {
        accumulator = memory[operand];
    }

    public void store(int operand) {
        memory[operand] = accumulator;
    }

    public void add(int operand) {
        accumulator += memory[operand];
    }

    public void subtract(int operand) {
        accumulator -= memory[operand];
    }

    public void divide(int operand) {
        accumulator /= memory[operand];
    }

    public void multiply(int operand) {
        accumulator *= memory[operand];
    }

}
