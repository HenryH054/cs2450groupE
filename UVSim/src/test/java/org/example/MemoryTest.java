package test.java.org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.example.data.Memory;
import org.junit.jupiter.api.BeforeEach;

class MemoryTest {

    private Memory memory;

    @BeforeEach
    public void setUp() {
        memory = new Memory();
    }

    @Test
    public void testSetDataTruncatesToFourDigits() {
        // Arrange
        int index = 5;
        int inputValue = 123456;
        int expectedValue = 1234; // Expecting the first four digits

        // Act
        memory.setData(index, inputValue);

        // Assert
        assertEquals(expectedValue, memory.getData(index));
    }

    @Test
    public void testSetDataHandlesNegativeValue() {
        // Arrange
        int index = 5;
        int inputValue = -123456;
        int expectedValue = -1234; // Expecting the first four digits with the negative sign

        // Act
        memory.setData(index, inputValue);

        // Assert
        assertEquals(expectedValue, memory.getData(index));
    }

    @Test
    public void testGetDataRetrievesValue() {
        // Arrange
        int index = 5;
        int expectedValue = 5678;
        memory.setData(index, expectedValue);

        // Act
        int actualValue = memory.getData(index);

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetDataRetrievesZeroByDefault() {
        // Arrange
        int index = 5;
        int expectedValue = 0; // Default value should be 0

        // Act
        int actualValue = memory.getData(index);

        // Assert
        assertEquals(expectedValue, actualValue);
    }

}