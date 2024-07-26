package org.example.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides utility methods for reading from and writing to files.
 * @author Damon Morgan
 */
public class FileUtil {

    /**
     * Reads the contents of a file and returns them as a list of strings.
     *
     * @param file the file to read from
     * @return a list of strings read from the file
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
     * Reads the contents of a file and returns them as a list of integers.
     *
     * @param file the file to read from
     * @return a list of integers read from the file
     */
    public static List<Integer> readFileAsIntegerList(File file) {
        List<Integer> instructions = new ArrayList<>();
        if(file == null) {
            return instructions;
        }

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
     * Appends a message to the output area.
     *
     * @param instruction the message to append
     */
    public static String prependZerosToStringInstruction(String instruction) {
        int numDigits = 6;
        StringBuilder sb = new StringBuilder();
        if (instruction != null) {
            if(instruction.charAt(0) == '-') {
                instruction = instruction.substring(1);
                sb.append("-");
            }
            for (int i = instruction.length(); i < numDigits; i++) {
                sb.append("0");
            }
            sb.append(instruction);
            return sb.toString();
        }
        return null;
    }

    /**
     * Writes a list of integers to a file, prefixing positive numbers with a "+" sign.
     *
     * @param instructions the list of integers to write
     * @param filePath the path of the file to write to
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

