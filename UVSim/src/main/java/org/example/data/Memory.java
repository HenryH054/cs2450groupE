package org.example.data;

import java.util.Scanner;

public class Memory {
    public int[] data;

    public Memory() {
        this.data = new int[100];
    }

//    I/O operation:
//    READ = 10 Read a word from the keyboard into a specific location in memory.
//    WRITE = 11 Write a word from a specific location in memory to screen.
//    Load/store operations:
//    LOAD = 20 Load a word from a specific location in memory into the accumulator.
//    STORE = 21 Store a word from the accumulator into a specific location in memory.

    public void writeFileToMemory(int index, int value) {
        data[index] = value;
    }

    // Load/Store methods
    public int getData(int index) {
        return data[index];
    }

    public void setData(int operand, int value) {
        data[operand] = truncateToFourDigits(value);
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
}
