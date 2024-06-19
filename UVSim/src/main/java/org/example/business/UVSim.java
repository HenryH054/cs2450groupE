package org.example.business;

import org.example.controller.UVSimGUI;
import org.example.data.Memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class   UVSim {
    public Memory memory = new Memory();
    public CPU cpu = new CPU(memory);
    public Scanner inputScanner = new Scanner(System.in); // Create the Scanner for user input

    public static void main(String[] args) {
        UVSimGUI gui = new UVSimGUI();
        gui.createAndShowGUI();
    }
}
