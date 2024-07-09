//package org.example;
//
//import org.example.business.CPU;
//import org.example.presentation.EditWindow;
//import org.example.presentation.UVSimGUI;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//public class EditWindowTest {
//
//    private File tempFile;
//    private EditWindow editWindow;
//
//    @BeforeEach
//    public void setUp() throws IOException {
//        tempFile = File.createTempFile("instructions", ".txt");
//        tempFile.deleteOnExit();
//        editWindow = new EditWindow(new CPU(new UVSimGUI()));
//        editWindow.setFilePath(tempFile.getAbsolutePath());
//    }
//
//    @Test
//    public void testSaveInstructionsToFile() throws IOException {
//        List<String> instructions = new ArrayList<>();
//        instructions.add("+1000");
//        instructions.add("-2000");
//
//        EditWindow editWindowSpy = spy(editWindow);
//
//        editWindowSpy.saveInstructions(instructions);
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
//            String line;
//            List<String> fileContents = new ArrayList<>();
//            while ((line = reader.readLine()) != null) {
//                fileContents.add(line);
//            }
//
//            assertTrue(fileContents.contains("+1000"));
//            assertTrue(fileContents.contains("-2000"));
//        }
//    }
//
////    @Test
////    public void testAppendText() {
////        String text = "Hello, world!";
////        editWindow.appendText(text);
////        assertEquals(text, editWindow.getTextAreaText().trim());
////    }
////
////    @Test
////    public void testAppendInstructions() {
////        List<Integer> instructions = List.of(1234, 5678, 91011);
////        editWindow.appendInstructions(instructions);
////        String expectedText = "1234\n5678\n91011\n";
////        assertEquals(expectedText.trim(), editWindow.getTextAreaText().trim());
////    }
////
////    @Test
////    public void testSaveInstructions() throws IOException {
////        String filePath = "test_instructions.txt";
////        editWindow.setFilePath(filePath);
////        String text = "1234\n5678\n91011";
////        editWindow.getTextArea().setText(text);
////        editWindow.saveInstructions();
////
////        String savedText = new String(Files.readAllBytes(Paths.get(filePath)));
////        assertEquals(text, savedText.trim());
////
////        // Cleanup
////        Files.deleteIfExists(Paths.get(filePath));
////    }
////
////    @Test
////    public void testLoadInstructionsIntoMemory() {
////        String filePath = "test_instructions.txt";
////        editWindow.setFilePath(filePath);
////        List<Integer> instructions = List.of(1234, 5678, 91011);
////
////        when(uvSimGUI.getInstructions(new File(filePath))).thenReturn(instructions);
////
////        editWindow.loadInstructionsIntoMemory();
////        verify(uvSimGUI, times(1)).writeToMemory(instructions);
////    }
//}
