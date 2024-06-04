package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
public class UVSimTest{
    private UVSim uvSim;

    @BeforeEach
    public void setUp() {
        uvSim = new UVSim();
    }

    @Test
    public void load_LoadPositiveNumber_LoadsFromMemoryLocation() {
        int expectedValue = 1234;
        uvSim.accumulator = 0;
        int memoryLocation = 10;

        uvSim.memory[memoryLocation] = expectedValue;
        uvSim.load(memoryLocation);

        assertEquals(expectedValue, uvSim.accumulator);
    }

    @Test
    public void load_LoadNegativeNumber_LoadsNumberToAccumulator() {
        int expectedValue = -4321;
        uvSim.accumulator = 0;
        int memoryLocation = 10;

        uvSim.memory[memoryLocation] = expectedValue;
        uvSim.load(memoryLocation);

        assertEquals(expectedValue, uvSim.accumulator);
    }

    @Test
    public void store_StoreNegativeNumber_StoresNumberToMemoryLocation() {
        int expectedValue = -4321;
        uvSim.accumulator = expectedValue;
        int memoryLocation = 10;

        uvSim.memory[memoryLocation] = uvSim.accumulator;
        uvSim.store(memoryLocation);

        assertEquals(expectedValue, uvSim.memory[memoryLocation]);
    }

    @Test
    public void store_StorePositiveNumber_StoresNumberToMemoryLocation() {
        int expectedValue = 1234;
        uvSim.accumulator = expectedValue;
        int memoryLocation = 10;

        uvSim.memory[memoryLocation] = uvSim.accumulator;
        uvSim.store(memoryLocation);

        assertEquals(expectedValue, uvSim.memory[memoryLocation]);
    }
}