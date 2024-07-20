package org.example.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

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

