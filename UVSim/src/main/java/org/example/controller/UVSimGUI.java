package main.java.org.example.controller;

import main.java.org.example.business.UVSim;
import main.java.org.example.data.Memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class UVSimGUI extends JFrame {
    private Memory memory;
    private JFrame frame;
    private UVSim uvSim;
    private JPanel mainPanel;
    private JButton loadProgramButton;
    private JPanel panelTop;
    private JButton runProgram;
    private JTextField textField1;
    private JButton submitButton;
    private JTextArea outputArea;
    private JLabel OutputLabel;
    private String filePath;
    private JScrollPane outputScrollPane;

    public UVSimGUI() {
        memory = new Memory();
        uvSim = new UVSim();
        frame = new JFrame("UV Sim");

    }

    public void createAndShowGUI() {
        outputArea.setEditable(false);
        frame.setContentPane(mainPanel);
        frame.setTitle("UVSim GUI app");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(370,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField1.getText();
                outputArea.append(userInput);
                outputArea.append("\n");
            }
        });
        loadProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProgram();
            }
        });
    }

    private void loadProgram() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                int i = 0;
                while (scanner.hasNextInt() && i < 100) {
                    int instruction = scanner.nextInt();
                    memory.writeFileToMemory(i, instruction);
                    i++;
                }
                appendOutput("Program loaded successfully.\n");
            } catch (Exception e) {
                appendOutput("Error loading program: " + e.getMessage() + "\n");
            }
        }
    }

    public void appendOutput(String message) {
        outputArea.append(message + "\n");
    }


}
