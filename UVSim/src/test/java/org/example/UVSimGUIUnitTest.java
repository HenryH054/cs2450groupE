package org.example.presentation;

import org.example.business.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

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
    public void testGetInputField() {
        String input = JOptionPane.showInputDialog("Please enter a four-digit instruction:");
        assertNotNull(input);
        assertTrue(input.matches("^[-]?\\d{4}$"));
    }

}
