package test.java.org.example;

import main.java.org.example.business.UVSim;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.example.data.Memory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.example.TestNameLoggingExtension;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(TestNameLoggingExtension.class)
public class UVSimTest{
    private UVSim uvSim;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void read_PositiveNumber() {
        Memory memory = new Memory();
        InputStream originalIn = System.in;
        String input = "42";
        try {
            InputStream ioStream = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(ioStream);
            System.setIn(ioStream);
            memory.read(1, scanner);
            assertEquals(42, memory.data[1]);
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void read_NegativeNumber() {
        Memory memory = new Memory();
        InputStream originalIn = System.in;
        String input = "-42";
        try {
            InputStream ioStream = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(ioStream);
            System.setIn(ioStream);
            memory.read(1, scanner);
            assertEquals(-42, memory.data[1]);
        }
        finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void write_PositiveNumber() {
        Memory memory = new Memory();
        int number = 90;
        memory.data[1] = number;
        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        memory.write(1);

        String expectedOutput = number + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(original);
    }

    @Test
    public void write_NegativeNumber() {
        Memory memory = new Memory();
        int number = -90;
        memory.data[1] = number;
        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        memory.write(1);

        String expectedOutput = number + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(original);
    }

    @Test
    public void load_LoadPositiveNumber_LoadsFromMemoryLocation() {
        UVSim uvsim = new UVSim();
        int expectedValue = 1234;
        uvsim.cpu.accumulator = 0;
        int memoryLocation = 10;
        uvsim.memory.setData(memoryLocation, expectedValue);
        uvsim.memory.load(memoryLocation);

        assertEquals(expectedValue, uvsim.cpu.accumulator);
    }

    @Test
    public void load_LoadNegativeNumber_LoadsNumberToAccumulator() {
        UVSim uvsim = new UVSim();
        int expectedValue = -4321;
        uvsim.cpu.accumulator = 0;
        int memoryLocation = 10;

        uvsim.memory.setData(memoryLocation, expectedValue);
        uvsim.load(memoryLocation);

        assertEquals(expectedValue, uvsim.cpu.accumulator);
    }

    @Test
    public void store_StoreNegativeNumber_StoresNumberToMemoryLocation() {
        UVSim uvsim = new UVSim();
        int expectedValue = -4321;
        uvsim.cpu.accumulator = expectedValue;
        int memoryLocation = 10;

        uvsim.memory.setData(memoryLocation, uvsim.cpu.accumulator);
        uvsim.memory.store(memoryLocation);

        assertEquals(expectedValue, uvsim.memory.data[memoryLocation]);
    }

    @Test
    public void store_StorePositiveNumber_StoresNumberToMemoryLocation() {
        UVSim uvsim = new UVSim();
        int expectedValue = 1234;
        uvsim.cpu.accumulator = expectedValue;
        int memoryLocation = 10;

        uvsim.memory.setData(memoryLocation, uvsim.cpu.accumulator);
        uvSim.memory.store(memoryLocation);

        assertEquals(expectedValue, uvsim.memory.data[memoryLocation]);
    }


    @Test
    public void add_Test_Positive() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[7] = 10;
        uvsim.cpu.accumulator = 20;
        uvsim.cpu.add(7);
        assertEquals(30, uvSim.cpu.accumulator, "Accumulator should be 30 after adding 10");
    }

    @Test
    public void add_Test_Negative() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[8] = -15;
        uvsim.cpu.accumulator = 25;
        uvsim.cpu.add(8);
        assertEquals(10, uvsim.cpu.accumulator, "Accumulator should be 10 after adding -15");
    }

    @Test
    public void subtract_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[8] = 5;
        uvsim.cpu.accumulator = 20;
        uvsim.cpu.subtract(8);
        assertEquals(15, uvsim.cpu.accumulator, "Accumulator should be 15 after subtracting 5");
    }

    @Test
    public void subtract_Negative_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[9] = -10;
        uvsim.cpu.accumulator = 30;
        uvsim.cpu.subtract(9);
        assertEquals(40, uvsim.cpu.accumulator, "Accumulator should be 40 after subtracting -10 (effectively adding 10)");
    }

    @Test
    public void divide_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[9] = 5;
        uvsim.cpu.accumulator = 20;
        uvsim.cpu.divide(9);
        assertEquals(4, uvsim.cpu.accumulator, "Accumulator should be 4 after dividing 20 by 5");
    }


    @Test
    public void divide_ByZero_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[11] = 0;
        uvsim.cpu.accumulator = 20;
        try {
            uvSim.cpu.divide(11);
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }

    @Test
    public void multiply_Positive_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[10] = 4;
        uvsim.cpu.accumulator = 5;
        uvsim.cpu.multiply(10);
        assertEquals(20, uvsim.cpu.accumulator, "Accumulator should be 20 after multiplying 5 by 4");
    }

    @Test
    public void multiply_Negative_Test() {
        UVSim uvsim = new UVSim();
        uvsim.memory.data[12] = -3;
        uvsim.cpu.accumulator = 7;
        uvsim.cpu.multiply(12);
        assertEquals(-21, uvsim.cpu.accumulator, "Accumulator should be -21 after multiplying 7 by -3");
    }
    @Test
    public void branch_Test() { // FC: Test for BRANCH operation
        UVSim uvsim = new UVSim();
        uvsim.cpu.programCounter = 0; // FC: Set program counter to 0
        uvsim.cpu.branch(10); // FC: Execute BRANCH to location 10
        assertEquals(10, uvSim.programCounter, "Program counter should be 10 after branching");
    }

    @Test
    public void branchNeg_Test() { // FC: Test for BRANCHNEG operation
        uvSim.programCounter = 0; // FC: Set program counter to 0
        uvSim.accumulator = -5; // FC: Set accumulator to a negative value
        uvSim.branchNeg(10); // FC: Execute BRANCHNEG to location 10
        assertEquals(10, uvSim.programCounter, "Program counter should be 10 after branching on negative accumulator");
    }

    @Test
    public void branchNeg_NotTaken_Test() { // FC: Test for BRANCHNEG not taken
        uvSim.programCounter = 0; // FC: Set program counter to 0
        uvSim.accumulator = 5; // FC: Set accumulator to a positive value
        uvSim.branchNeg(10); // FC: Execute BRANCHNEG to location 10, but it should not be taken
        assertEquals(0, uvSim.programCounter, "Program counter should not change after branching on positive accumulator");
    }

    @Test
    public void branchZero_Test() { // FC: Test for BRANCHZERO operation
        uvSim.programCounter = 0; // FC: Set program counter to 0
        uvSim.accumulator = 0; // FC: Set accumulator to zero
        uvSim.branchZero(10); // FC: Execute BRANCHZERO to location 10
        assertEquals(10, uvSim.programCounter, "Program counter should be 10 after branching on zero accumulator");
    }

    @Test
    public void branchZero_NotTaken_Test() { // FC: Test for BRANCHZERO not taken
        uvSim.programCounter = 0; // FC: Set program counter to 0
        uvSim.accumulator = 5; // FC: Set accumulator to a non-zero value
        uvSim.branchZero(10); // FC: Execute BRANCHZERO to location 10, but it should not be taken
        assertEquals(0, uvSim.programCounter, "Program counter should not change after branching on non-zero accumulator");
    }

    @Test
    public void halt_Test() { // FC: Test for HALT operation
        uvSim.programCounter = 0; // FC: Set program counter to 0
        uvSim.halt(); // FC: Execute HALT
        assertEquals(-1, uvSim.programCounter, "Program counter should be -1 after halting");
    }
}
