package org.example.presentation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Utility class for file operations, including reading and writing instructions.
 * @author Damon Morgan
 */
public class FileUtil {

    /**
     * Reads a file and returns its content as a list of strings.
     *
     * @param file The file to read.
     * @return List of strings representing the file content.
     */
    public static List<String> readFileAsStringList(File file) {
        List<String> instructions = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                instructions.add(scanner.next());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
        return instructions;
    }

    /**
     * Reads a file and returns its content as a list of integers.
     *
     * @param file The file to read.
     * @return List of integers representing the file content.
     */
    public static List<Integer> readFileAsIntegerList(File file) {
        List<Integer> instructions = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                instructions.add(scanner.nextInt());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
        return instructions;
    }

    /**
     * Writes a list of instructions to a file.
     *
     * @param instructions List of integers representing the instructions.
     * @param filePath The path to the file to write.
     */
    public static void writeInstructionsToFile(List<Integer> instructions, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int instruction : instructions) {
                writer.write((instruction >= 0 ? "+" : "") + instruction);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }
}

