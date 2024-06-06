package test.java.org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.example.UVSim;

import static org.junit.jupiter.api.Assertions.*;
public class UVSimTest{
    private UVSim uvSim;

    @BeforeEach
    public void setUp() {
        uvSim = new UVSim();
    }

    @Test
    public void read_PositiveNumber() {
        String input = "42";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        uvSim.read(01);
        assertEquals(42, uvSim.memory[01]);
    }

    @Test
    public void read_NegativeNumber() {
        String input = "-42";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        uvSim.read(01);
        assertEquals(-42, uvSim.memory[01]);
    }

    @Test
    public void write_PositiveNumber() {
        int number = 90;
        uvSim.memory[01] = number;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        uvSim.write(01);

        String expectedOutput = number + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void write_NegativeNumber() {
        int number = -90;
        uvSim.memory[01] = number;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        uvSim.write(01);

        String expectedOutput = number + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
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
