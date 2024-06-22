package test.java.org.example;

import main.java.org.example.business.IOHandler;
import main.java.org.example.controller.UVSimGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.data.Memory;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class IOHandlerTest {
    private Memory memory;
    private UVSimGUI uvSimGUI;
    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        memory = mock(Memory.class);
        uvSimGUI = mock(UVSimGUI.class);
        ioHandler = new IOHandler(memory, uvSimGUI);
    }

    @Test
    public void testRead() {
        // Arrange
        int index = 5;
        int expectedValue = 1234;
        when(uvSimGUI.getInputField()).thenReturn(expectedValue);

        // Act
        ioHandler.read(index);

        // Assert
        verify(memory).setData(index, expectedValue);
    }

    @Test
    public void testReadZeroInput() {
        // Arrange
        int index = 5;
        int zeroInput = 0;
        when(uvSimGUI.getInputField()).thenReturn(zeroInput);

        // Act
        ioHandler.read(index);

        // Assert
        verify(memory).setData(index, zeroInput);
    }

    @Test
    public void testReadMaxInput() {
        // Arrange
        int index = 5;
        int maxInput = 9999;
        when(uvSimGUI.getInputField()).thenReturn(maxInput);

        // Act
        ioHandler.read(index);

        // Assert
        verify(memory).setData(index, maxInput);
    }


    @Test
    public void testWrite() {
        // Arrange
        int index = 5;
        int valueInMemory = 1234;
        when(memory.getData(index)).thenReturn(valueInMemory);

        // Act
        ioHandler.write(index);

        // Assert
        verify(uvSimGUI).appendOutput(String.valueOf(valueInMemory));
    }

    @Test
    public void testWriteZeroValue() {
        // Arrange
        int index = 5;
        int zeroValue = 0;
        when(memory.getData(index)).thenReturn(zeroValue);

        // Act
        ioHandler.write(index);

        // Assert
        verify(uvSimGUI).appendOutput(String.valueOf(zeroValue));
    }

    @Test
    public void testWriteNegativeValue() {
        // Arrange
        int index = 5;
        int negativeValue = -1234;
        when(memory.getData(index)).thenReturn(negativeValue);

        // Act
        ioHandler.write(index);

        // Assert
        verify(uvSimGUI).appendOutput(String.valueOf(negativeValue));
    }

}