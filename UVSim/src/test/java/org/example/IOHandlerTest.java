package org.example;

import org.example.business.IOHandler;
import org.example.ui.UVSimGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.data.Memory;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the IOHandler class.
 * @author Damon Morgan
 */
class IOHandlerTest {
    private Memory memory;
    private UVSimGUI gui;
    private IOHandler ioHandler;

    @BeforeEach
    void setUp() {
        memory = mock(Memory.class);
        gui = mock(UVSimGUI.class);
        ioHandler = new IOHandler(memory, gui);
    }

    @Test
    void testRead() {
        // Arrange
        int index = 0;
        int inputValue = 1234;
        when(gui.getInputField()).thenReturn(inputValue);

        // Act
        ioHandler.read(index);

        // Assert
        verify(gui).getInputField();
        verify(memory).setData(index, inputValue);
    }

    @Test
    void testWrite() {
        // Arrange
        int index = 0;
        int memoryValue = 5678;
        when(memory.getData(index)).thenReturn(memoryValue);

        // Act
        ioHandler.write(index);

        // Assert
        verify(memory).getData(index);
        verify(gui).appendInstructionToTextArea(String.valueOf(memoryValue));
    }

}