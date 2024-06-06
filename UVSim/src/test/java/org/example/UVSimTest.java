package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

        
    @Test
    public void add_Test_Positive() {
        uvSim.memory[7] = 10;
        uvSim.accumulator = 20;
        uvSim.add(7);
        assertEquals(30, uvSim.accumulator, "Accumulator should be 30 after adding 10");
    }
    
    @Test
    public void add_Test_Negative() {
        uvSim.memory[8] = -15;
        uvSim.accumulator = 25;
        uvSim.add(8);
        assertEquals(10, uvSim.accumulator, "Accumulator should be 10 after adding -15");
    }

    @Test
    public void subtract_Test() {
        uvSim.memory[8] = 5;
        uvSim.accumulator = 20;
        uvSim.subtract(8);
        assertEquals(15, uvSim.accumulator, "Accumulator should be 15 after subtracting 5");
    }
    
    @Test
    public void subtract_Negative_Test() {
        uvSim.memory[8] = -10;
        uvSim.accumulator = 30;
        uvSim.subtract(8);
        assertEquals(40, uvSim.accumulator, "Accumulator should be 40 after subtracting -10 (effectively adding 10)");
    }

    @Test
    public void divide_Test() {
        uvSim.memory[9] = 5;
        uvSim.accumulator = 20;
        uvSim.divide(9);
        assertEquals(4, uvSim.accumulator, "Accumulator should be 4 after dividing 20 by 5");
    }
    

    @Test
    public void divide_ByZero_Test() {
        uvSim.memory[11] = 0;
        uvSim.accumulator = 20;
        try {
            uvSim.divide(11);
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }

    @Test
    public void multiply_Positive_Test() {
        uvSim.memory[10] = 4;
        uvSim.accumulator = 5;
        uvSim.multiply(10);
        assertEquals(20, uvSim.accumulator, "Accumulator should be 20 after multiplying 5 by 4");
    }
    
    @Test
    public void multiply_Negative_Test() {
        uvSim.memory[12] = -3;
        uvSim.accumulator = 7;
        uvSim.multiply(12);
        assertEquals(-21, uvSim.accumulator, "Accumulator should be -21 after multiplying 7 by -3");
    }
}
