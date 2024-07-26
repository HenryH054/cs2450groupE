package org.example;

import org.example.file.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FileUtilTest {

    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = File.createTempFile("testfile", ".txt");
        tempFile.deleteOnExit(); // Ensure file is deleted after the test
    }

    @Test
    void testReadFileAsStringList() throws IOException {
        // Arrange
        List<String> expected = Arrays.asList("Line1", "Line2", "Line3");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : expected) {
                writer.write(line);
                writer.newLine();
            }
        }

        // Act
        List<String> actual = FileUtil.readFileAsStringList(tempFile);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testReadFileAsIntegerList() throws IOException {
        // Arrange
        List<Integer> expected = Arrays.asList(123, -456, 789);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (int number : expected) {
                writer.write(String.valueOf(number));
                writer.newLine();
            }
        }

        // Act
        List<Integer> actual = FileUtil.readFileAsIntegerList(tempFile);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testPrependZerosToStringInstruction() {
        // Arrange
        String input = "123";
        String expected = "000123";

        // Act
        String actual = FileUtil.prependZerosToStringInstruction(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testPrependZerosToStringInstructionWithNegative() {
        // Arrange
        String input = "-123";
        String expected = "-000123";

        // Act
        String actual = FileUtil.prependZerosToStringInstruction(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testPrependZerosToStringInstructionWithNull() {
        // Act
        String actual = FileUtil.prependZerosToStringInstruction(null);

        // Assert
        assertNull(actual);
    }

    @Test
    void testWriteInstructionsToFile() throws IOException {
        // Arrange
        List<Integer> instructions = Arrays.asList(123, -456, 789);
        String filePath = tempFile.getAbsolutePath();

        // Act
        FileUtil.writeInstructionsToFile(instructions, filePath);

        // Assert
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            assertEquals("+123", reader.readLine());
            assertEquals("-456", reader.readLine());
            assertEquals("+789", reader.readLine());
        }
    }
}