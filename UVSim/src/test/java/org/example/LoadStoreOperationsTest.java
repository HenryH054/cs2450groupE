package org.example;

import org.example.business.CPU;
import org.example.business.LoadStoreOperations;
import org.example.data.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class LoadStoreOperationsTest {
    private CPU mockCPU;
    private Memory mockMemory;
    private LoadStoreOperations loadStoreOperations;

    @BeforeEach
    public void setUp() {
        mockCPU = Mockito.mock(CPU.class);
        mockMemory = Mockito.mock(Memory.class);
        loadStoreOperations = new LoadStoreOperations(mockCPU, mockMemory);
    }

    @Test
    public void testLoad() {
        int operand = 5;
        int value = 1234;

        when(mockMemory.getData(operand)).thenReturn(value);

        loadStoreOperations.load(operand);

        verify(mockMemory).getData(operand);
        verify(mockCPU).setAccumulator(value);
    }

    @Test
    public void testStore() {
        int operand = 5;
        int accumulator = 1234;

        loadStoreOperations.store(operand, accumulator);

        verify(mockMemory).setData(operand, accumulator);
    }

}