package org.example.presentation;

import org.example.business.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests for the UVSimGUI class.
 * @author Damon Morgan
 */
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
    public void testGetInstructionsAsIntegerListFromFile() throws IOException {
        UVSimGUI uvSimGUI = spy(new UVSimGUI());
        Random rnd = new Random();

        File tempFile = File.createTempFile("instructions", ".txt");
        List<Integer> expectedInstructions = new ArrayList<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < 100; i++) {
                int random4Digit = 1000 + rnd.nextInt(9000);
                expectedInstructions.add(random4Digit);
                bw.write(String.valueOf(random4Digit));
                bw.newLine();
            }
        }

        List<Integer> actualInstructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(100, actualInstructions.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(expectedInstructions.get(i), actualInstructions.get(i));
        }
    }

    @Test
    public void testGetInstructionsAsIntegerListFromFile_NegativeValues() throws IOException {
        UVSimGUI uvSimGUI = spy(new UVSimGUI());
        Random rnd = new Random();

        File tempFile = File.createTempFile("instructions", ".txt");
        List<Integer> expectedInstructions = new ArrayList<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < 100; i++) {
                int random4Digit = 1000 + rnd.nextInt(9000) * -1;
                expectedInstructions.add(random4Digit);
                bw.write(String.valueOf(random4Digit));
                bw.newLine();
            }
        }

        List<Integer> actualInstructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(100, actualInstructions.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(expectedInstructions.get(i), actualInstructions.get(i));
        }
    }

    @Test
    public void testGetInstructionsAsIntegerListFromEmptyFile() throws IOException {
        File tempFile = File.createTempFile("empty", ".txt");

        List<Integer> instructions = FileUtil.readFileAsIntegerList(tempFile);

        assertTrue(instructions.isEmpty());
    }

    @Test
    public void testGetInstructionsAsIntegerListFromFileWithNonNumericData() throws IOException {
        File tempFile = File.createTempFile("non_numeric", ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("abcd");
            bw.newLine();
            bw.write("1234");
            bw.newLine();
            bw.write("xyz");
        }

        List<Integer> instructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(1, instructions.size());
        assertEquals(Integer.valueOf(1234), instructions.getFirst());
    }

}
