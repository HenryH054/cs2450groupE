package main.java.org.example.controller;

import main.java.org.example.business.UVSim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UVSimGUI extends JFrame {
    private UVSim uvSim;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton submitButton;
    private JTextArea textArea1;
    private JButton fileUploadButton;
    private String filePath;

    public UVSimGUI() {
        uvSim = new UVSim();
        setContentPane(mainPanel);
        setTitle("UVSim GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField1.getText();
                textArea1.append(userInput);
                textArea1.append("\n");
            }
        });
        fileUploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int response = fileChooser.showOpenDialog(null);//select file to open

                if(response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    textArea1.append("File path: " + file.getName());
                    textArea1.append("\n");
                    filePath = file.getPath();
                }

            }
        });
    }

    public static void main(String[] args) {
        new UVSimGUI();
    }

    public String getFilePath() {
        return filePath;
    }
}
