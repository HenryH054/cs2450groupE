package org.example.presentation;

import org.example.business.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UVSimGUIUnitTest {

    private UVSimGUI uvSimGUI;
    private CPU mockCPU;

    @BeforeEach
    public void setUp() {
        uvSimGUI = new UVSimGUI();
        mockCPU = mock(CPU.class);
        uvSimGUI.setCpu(mockCPU);
    }

    @Test
    public void testAppendOutput() {
        uvSimGUI.appendOutput("Test message");
        assertTrue(uvSimGUI.getOutputArea().getText().contains("Test message"));
    }

    @Test
    public void testRunProgram() {
        uvSimGUI.runProgramButtonActionPerformed(null);
        verify(mockCPU, times(1)).execute();
    }

    @Test
    public void testLoadProgram() {
        // Mock file chooser to return a specific file
        JFileChooser mockFileChooser = mock(JFileChooser.class);
        when(mockFileChooser.showOpenDialog(any())).thenReturn(JFileChooser.APPROVE_OPTION);
        when(mockFileChooser.getSelectedFile()).thenReturn(new File("test_program.txt"));

        // Simulate the load button action
        uvSimGUI.loadProgramButtonActionPerformed(null);

        // Verify if the program loads and the output area is updated
        assertTrue(uvSimGUI.getOutputArea().getText().contains("Program loaded successfully."));
    }

}
