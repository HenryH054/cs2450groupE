package main.java.org.example.business;

import main.java.org.example.controller.UVSimGUI;

/**
 * Entry point for the UVSim application.
 * @author Damon Morgan
 */
public class UVSim {

    public static void main(String[] args) {
        UVSimGUI gui = new UVSimGUI();
        gui.createAndShowGUI();
    }
}
