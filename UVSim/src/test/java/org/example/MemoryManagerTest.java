package org.example;

import org.example.data.Memory;
import org.example.data.MemoryManager;
import org.example.ui.UVSimGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MemoryManagerTest {
    private UVSimGUI mockUvSimGUI;
    private Memory mockMemory;
    private MemoryManager memoryManager;

    @BeforeEach
    public void setUp() {
        mockUvSimGUI = Mockito.mock(UVSimGUI.class);
        mockMemory = Mockito.mock(Memory.class);
        memoryManager = new MemoryManager(mockUvSimGUI, mockMemory);
    }

    @Test
    public void testWriteToMemoryFromStringList_ValidInstructions() {
        List<String> instructions = Arrays.asList("1000", "2000", "3000");

        memoryManager.writeToMemoryFromStringList(instructions);

        verify(mockMemory).setData(0, 1000);
        verify(mockMemory).setData(1, 2000);
        verify(mockMemory).setData(2, 3000);
        verifyNoMoreInteractions(mockMemory);
    }

    @Test
    public void testWriteToMemoryFromStringList_InvalidInstruction() {
        List<String> instructions = Arrays.asList("1000", "abcd", "3000");

        memoryManager.writeToMemoryFromStringList(instructions);

        verify(mockMemory).setData(0, 1000);
        verify(mockMemory, never()).setData(1, 0);
        verify(mockUvSimGUI).appendMessageToTextArea(
                "Invalid instruction:\nabcd is either too large or an incorrect input\nPlease enter a four digit number.");
    }

    @Test
    public void testWriteToMemoryFromIntegerList() {
        List<Integer> instructions = Arrays.asList(1000, 2000, 3000);

        memoryManager.writeToMemoryFromIntegerList(instructions);

        verify(mockMemory).setData(0, 1000);
        verify(mockMemory).setData(1, 2000);
        verify(mockMemory).setData(2, 3000);
        verifyNoMoreInteractions(mockMemory);
    }
}