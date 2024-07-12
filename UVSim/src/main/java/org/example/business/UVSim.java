package org.example.business;

import org.example.presentation.UVSimGUI;

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
