/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.org.example.controller;


import main.java.org.example.business.CPU;
import main.java.org.example.business.IOHandler;
import org.example.data.Memory;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author dj
 */
public class UVSimGUI extends javax.swing.JFrame {

    private CPU cpu;
    private IOHandler ioHandler;
    private Memory memory;

    /**
     * Creates new form UVSimGUI
     */
    public UVSimGUI() {
        memory = new Memory();
        ioHandler = new IOHandler(memory, this);
        cpu = new CPU(memory, ioHandler);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loadProgramButton = new javax.swing.JButton();
        runProgramButton = new javax.swing.JButton();
        resetProgramButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 0));

        loadProgramButton.setBackground(new java.awt.Color(204, 255, 255));
        loadProgramButton.setText("Load Program");
        loadProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadProgramButtonActionPerformed(evt);
            }
        });

        runProgramButton.setBackground(new java.awt.Color(204, 255, 255));
        runProgramButton.setText("Run Program");
        runProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runProgramButtonActionPerformed(evt);
            }
        });

        resetProgramButton.setBackground(new java.awt.Color(204, 255, 255));
        resetProgramButton.setText("Reset Program");
        resetProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetProgramButtonActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane1.setViewportView(outputArea);

        jLabel1.setBackground(new java.awt.Color(204, 51, 0));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("                          UVSIM");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(loadProgramButton)
                        .addGap(18, 18, 18)
                        .addComponent(runProgramButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetProgramButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runProgramButton)
                    .addComponent(loadProgramButton)
                    .addComponent(resetProgramButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runProgramButtonActionPerformed
        // TODO add your handling code here:
        runProgram();
    }//GEN-LAST:event_runProgramButtonActionPerformed

    private void loadProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadProgramButtonActionPerformed
        // TODO add your handling code here:
        loadProgram();
    }//GEN-LAST:event_loadProgramButtonActionPerformed

    private void resetProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetProgramButtonActionPerformed
        // TODO add your handling code here:
        resetProgram();
    }//GEN-LAST:event_resetProgramButtonActionPerformed

    public void appendOutput(String message) {
        outputArea.append(message + "\n");
    }

    public void createAndShowGUI() {
        JOptionPane.showMessageDialog(null,
                "Welcome to the UV Sim!\n"
                + "Click the Load program button to load a program file from your local machine.\n"
                + "Click the run program button to run the program from the file\n"
                + "When prompted enter a 4 digit instruction.\n\n"
                + "To reset the simulator and run a new program, click the reset button");
        outputArea.setEditable(false);
        setContentPane(mainPanel);
        setTitle("UVSIM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        appendOutput("Welcome to UVSIM!\nA software simlulator that interprets BasicML\n\n"
                + "Step 1: Click the \"Load Program\" button to load the program\n"
                + "Step 2: Click the \"Run Program\" button to run the program\n"
                + "Step 3: Click the \"Reset Program\" button to reset the simulator\nand run a new program\n");

    }

    public int getInputField() {
        String inputText = JOptionPane.showInputDialog("Please enter a four digit instruction: ");
        while (!inputText.matches("^[-]?\\d{4}$")) {
            inputText = JOptionPane.showInputDialog("Please enter a four digit instruction: ");
        }

        return Integer.parseInt(inputText);
    }

    private void loadProgram() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(mainPanel);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                int i = 0;
                while (scanner.hasNextInt() && i < 100) {
                    int instruction = scanner.nextInt();
                    memory.setData(i, instruction);
                    i++;
                }
                appendOutput("Program loaded successfully.\n");
            } catch (Exception e) {
                appendOutput("Error loading program: " + e.getMessage() + "\n");
            }
        }
    }

    private void runProgram() {
        cpu.execute();
        appendOutput("Program executed.\n");
    }

    private void resetProgram() {
        memory.clear();
        cpu.reset();
        outputArea.setText("");
        appendOutput("Program reset.\n");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadProgramButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JButton resetProgramButton;
    private javax.swing.JButton runProgramButton;
    // End of variables declaration//GEN-END:variables
}
