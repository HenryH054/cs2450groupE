//package org.example;
//
//import org.example.business.CPU;
//import org.example.presentation.EditWindow;
//import org.example.presentation.UVSimGUI;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class EditWindowTest {
//
//    private EditWindow editWindow;
//    private UVSimGUI uvSimGUI;
//
//    @BeforeEach
//    public void setUp() {
//        uvSimGUI = mock(UVSimGUI.class);
//        CPU cpu = new CPU(uvSimGUI);
//        editWindow = new EditWindow(cpu);
//
//        editWindow.setUvSimGUI(uvSimGUI);
//    }
//
//    @Test
//    public void testAppendText() {
//        String text = "Hello, world!";
//        editWindow.appendText(text);
//        assertEquals(text, editWindow.getTextAreaText().trim());
//    }
//
//    @Test
//    public void testAppendInstructions() {
//        List<Integer> instructions = List.of(1234, 5678, 91011);
//        editWindow.appendInstructions(instructions);
//        String expectedText = "1234\n5678\n91011\n";
//        assertEquals(expectedText.trim(), editWindow.getTextAreaText().trim());
//    }
//
//    @Test
//    public void testSaveInstructions() throws IOException {
//        String filePath = "test_instructions.txt";
//        editWindow.setFilePath(filePath);
//        String text = "1234\n5678\n91011";
//        editWindow.getTextArea().setText(text);
//        editWindow.saveInstructions();
//
//        String savedText = new String(Files.readAllBytes(Paths.get(filePath)));
//        assertEquals(text, savedText.trim());
//
//        // Cleanup
//        Files.deleteIfExists(Paths.get(filePath));
//    }
//
//    @Test
//    public void testLoadInstructionsIntoMemory() {
//        String filePath = "test_instructions.txt";
//        editWindow.setFilePath(filePath);
//        List<Integer> instructions = List.of(1234, 5678, 91011);
//
//        when(uvSimGUI.getInstructions(new File(filePath))).thenReturn(instructions);
//
//        editWindow.loadInstructionsIntoMemory();
//        verify(uvSimGUI, times(1)).writeToMemory(instructions);
//    }
//}
