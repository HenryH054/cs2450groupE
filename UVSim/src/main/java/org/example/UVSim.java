package org.example;

import org.example.controller.AppController;

/**
 * Entry point for the UVSim application.
 * @author Damon Morgan
 */
public class UVSim {

    public static void main(String[] args) {
        AppController app = new AppController();
        app.getGui().createAndShowGUI();
    }
}
