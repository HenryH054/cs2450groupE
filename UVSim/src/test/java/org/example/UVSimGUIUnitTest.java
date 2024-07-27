package org.example;

import org.example.business.CPU;
import org.example.controller.AppController;
import org.example.data.Memory;
import org.example.file.FileUtil;
import org.example.ui.UVSimGUI;
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
        AppController appController = mock(AppController.class);
        uvSimGUI = new UVSimGUI(appController);
    }

    @Test
    public void testGetInstructionsAsIntegerListFromFile() throws IOException {
        Random rnd = new Random();

        File tempFile = File.createTempFile("instructions", ".txt");
        List<Integer> expectedInstructions = new ArrayList<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < Memory.SIZE; i++) {
                int random4Digit = 1000 + rnd.nextInt(9000);
                expectedInstructions.add(random4Digit);
                bw.write(String.valueOf(random4Digit));
                bw.newLine();
            }
        }

        List<Integer> actualInstructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(250, actualInstructions.size());
        for (int i = 0; i < Memory.SIZE; i++) {
            assertEquals(expectedInstructions.get(i), actualInstructions.get(i));
        }
    }

    @Test
    public void testGetInstructionsAsIntegerListFromFile_NegativeValues() throws IOException {
        Random rnd = new Random();

        File tempFile = File.createTempFile("instructions", ".txt");
        List<Integer> expectedInstructions = new ArrayList<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < Memory.SIZE; i++) {
                int random4Digit = 1000 + rnd.nextInt(9000) * -1;
                expectedInstructions.add(random4Digit);
                bw.write(String.valueOf(random4Digit));
                bw.newLine();
            }
        }

        List<Integer> actualInstructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(250, actualInstructions.size());
        for (int i = 0; i < Memory.SIZE; i++) {
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
            bw.write("1234");
            bw.newLine();
            bw.write("xyz");
        }

        List<Integer> instructions = FileUtil.readFileAsIntegerList(tempFile);

        assertEquals(1, instructions.size());
        assertEquals(Integer.valueOf(1234), instructions.getFirst());
    }

}
