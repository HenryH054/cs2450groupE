package org.example.business;
import org.example.business.CPU;

public class ArithmeticOperations {
    private final CPU cpu;

    public ArithmeticOperations(CPU cpu) {
        this.cpu = cpu;
    }

    public void add(int operand) {
        int accumulator = cpu.getAccumulator();
        cpu.setAccumulator(accumulator + cpu.getMemory().getData(operand));
    }

    public void subtract(int operand) {
        int accumulator = cpu.getAccumulator();
        cpu.setAccumulator(accumulator - cpu.getMemory().getData(operand));
    }

    public void divide(int operand) {
        int accumulator = cpu.getAccumulator();
        int data = cpu.getMemory().getData(operand);

        if (data != 0) {
            cpu.setAccumulator(accumulator / data);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        int accumulator = cpu.getAccumulator();
        cpu.setAccumulator(accumulator * cpu.getMemory().getData(operand));
    }
}