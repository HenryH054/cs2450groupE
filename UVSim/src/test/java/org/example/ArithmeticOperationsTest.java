package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.example.business.ArithmeticOperations;
import org.example.business.CPU;
import org.example.data.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArithmeticOperationsTest {
    private CPU cpu;
    private Memory memory;
    private ArithmeticOperations arithmeticOperations;

    @BeforeEach
    public void setUp() {
        cpu = new CPU(null );
        arithmeticOperations = new ArithmeticOperations(cpu);
    }

    @Test
    public void testAdd() {
        cpu.getMemory().setData(10, 5);
        cpu.setAccumulator(3);
        arithmeticOperations.add(10);
        assertEquals(8, cpu.getAccumulator());
    }

    @Test
    public void testSubtract() {
        cpu.getMemory().setData(10, 5);
        cpu.setAccumulator(10);
        arithmeticOperations.subtract(10);
        assertEquals(5, cpu.getAccumulator());
    }

    @Test
    public void testDivide() {
        cpu.getMemory().setData(10, 5);
        cpu.setAccumulator(10);
        arithmeticOperations.divide(10);
        assertEquals(2, cpu.getAccumulator());
    }

    @Test
    public void testDivideByZero() {
        cpu.getMemory().setData(10, 0);
        cpu.setAccumulator(10);
        assertThrows(ArithmeticException.class, () -> arithmeticOperations.divide(10));
    }

    @Test
    public void testMultiply() {
        cpu.getMemory().setData(10, 5);
        cpu.setAccumulator(3);
        arithmeticOperations.multiply(10);
        assertEquals(15, cpu.getAccumulator());
    }
}
