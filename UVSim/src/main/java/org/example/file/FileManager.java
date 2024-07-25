package org.example.file;

import org.example.data.Memory;
import org.example.ui.UVSimGUI;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages file operations related to saving memory contents.
 * @author Damon Morgan
 */
public class FileManager {
    private Memory memory;
    private UVSimGUI uvSimGUI;

    public FileManager(Memory memory, UVSimGUI uvSimGUI) {
        this.memory = memory;
        this.uvSimGUI = uvSimGUI;
    }

    /**
     * Saves the instructions from the text area to the file.
     */
    public void saveInstructionsToFileFromMemory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (int i = 0; i < Memory.SIZE; i++) {
                int data = memory.getData(i);
                String item = String.valueOf(data);
                if (item.charAt(0) == '-' || data == 0) {
                    writer.write(item);
                    writer.newLine();
                } else {
                    writer.write("+" + item);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            uvSimGUI.appendMessageToTextArea("Could not save instructions to " + filePath);
        }
    }

    public File saveAsInstructionsToFileFromMemory() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                for (int i = 0; i < Memory.SIZE; i++) {
                    int data = memory.getData(i);
                    String item = String.valueOf(data);
                    if (item.charAt(0) == '-' || data == 0) {
                        writer.write(item);
                        writer.newLine();
                    } else {
                        writer.write("+" + item);
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                uvSimGUI.appendMessageToTextArea("Could not save instructions to " + fileToSave.getAbsolutePath());
                return null;
            }
            return fileToSave;
        }
        return null;
    }
}
