package main.java.org.example.business;

import main.java.org.example.business.CPU;
import main.java.org.example.controller.UVSimGUI;
import org.example.data.Memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class   UVSim {

    public static void main(String[] args) {
        UVSimGUI gui = new UVSimGUI();
        gui.createAndShowGUI();
    }
}
