//package org.example;
//
//import org.example.business.CPU;
//import org.example.presentation.EditWindow;
//import org.example.File.FileUtil;
//import org.example.presentation.UVSimGUI;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class EditWindowTest {
//
//    private File tempFile;
//    private EditWindow editWindow;
//    UVSimGUI uvSimGUI;
//    CPU cpu;
//
//    @BeforeEach
//    public void setUp() throws IOException {
//        uvSimGUI = spy(new UVSimGUI());
//        cpu = new CPU(uvSimGUI);
//        editWindow = new EditWindow(cpu);
//        tempFile = File.createTempFile("instructions", ".txt");
//        editWindow.setFilePath(tempFile.getAbsolutePath());
//        tempFile.delete();
//    }
//
//    @Test
//    public void testSaveInstructionsToFileToFileFromMemory1() throws IOException {
//        for (int i = 0; i < 100; i++) {
//            cpu.getMemory().setData(i, i);
//        }
//
//        editWindow.saveInstructionsToFileFromMemory();
//
//        List<String> lines = Files.readAllLines(tempFile.toPath());
//        assertEquals(100, lines.size()); // Check if 100 lines are written
//        for (int i = 0; i < 100; i++) {
//            if(i == 0) {
//                assertEquals("0", lines.get(i));
//            }else{
//                assertEquals(String.format("%+d", i), lines.get(i));
//            }
//        }
//    }
//
//    @Test
//    public void testSaveInstructionsToFileToFile_FromMemory_NegativeValues() throws IOException {
//        for (int i = 0; i < 10; i++) {
//            cpu.getMemory().setData(i, -i-2);
//        }
//
//        editWindow.saveInstructionsToFileFromMemory();
//
//        List<Integer> list = FileUtil.readFileAsIntegerList(tempFile);
//
//        assertEquals(-11, list.get(9));
//    }
//
////    @Test
////    public void testAppendInstructions() {
////        List<Integer> instructions = List.of(1234, 5678, 91011);
////        editWindow.appendInstructions(instructions);
////        String expectedText = "+1234\n+5678\n+91011\n";
////        assertEquals(expectedText.trim(), editWindow.getTextAreaText().trim());
////    }
//}
