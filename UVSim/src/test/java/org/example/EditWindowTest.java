package org.example;

import org.example.controller.AppController;
import org.example.ui.EditWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class EditWindowTest {
    private EditWindow editWindow;
    private AppController mockAppController;
    private JTextArea textArea;

    @BeforeEach
    public void setUp() {
        mockAppController = mock(AppController.class, RETURNS_DEEP_STUBS);
        editWindow = new EditWindow(mockAppController);
        textArea = editWindow.getTextArea();
    }

    @Test
    public void testAppendInstructions() {

        List<String> instructions = Arrays.asList("1001", "2002", "3003");

        editWindow.appendInstructions(instructions);

        String expectedText = "1001\n2002\n3003\n";
        assertEquals(expectedText, textArea.getText());
    }

    @Test
    public void testExtractInstructionsFromTextArea() {
        String text = "1001\n2002\n3003";
        textArea.setText(text);

        List<String> instructions = editWindow.extractInstructionsFromTextArea();

        assertEquals(Arrays.asList("1001", "2002", "3003"), instructions);
    }

    @Test
    public void testExtractInstructionsFromTextAreaInt() {
        String text = "1001\n2002\n3003";
        textArea.setText(text);

        List<Integer> instructions = editWindow.extractInstructionsFromTextAreaInt();

        assertEquals(Arrays.asList(1001, 2002, 3003), instructions);
    }

}
