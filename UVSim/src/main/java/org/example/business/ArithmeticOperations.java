package org.example.business;

import org.example.data.Memory;

public class ArithmeticOperations {
    private final Memory memory;
    private final CPU cpu;

    public ArithmeticOperations(Memory memory, CPU cpu) {
        this.memory = memory;
        this.cpu = cpu;
    }

    public void add(int operand) {
        int accumulator = cpu.getAccumulator();
        cpu.setAccumulator(accumulator + memory.getData(operand));
    }

    public void subtract(int operand) {
        int accumulator = cpu.getAccumulator();
        cpu.setAccumulator(accumulator - memory.getData(operand));
    }

    public void divide(int operand) {
        int accumulator = cpu.getAccumulator();
        int data = memory.getData(operand);

        if (data != 0) {
            cpu.setAccumulator(accumulator / data);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        int accumulator = cpu.getAccumulator();
        int num1 = memory.getData(operand);
        int num2 = accumulator * num1;
        cpu.setAccumulator(num2);
    }
}