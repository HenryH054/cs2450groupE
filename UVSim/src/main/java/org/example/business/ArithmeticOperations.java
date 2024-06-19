package org.example.business;

import main.java.org.example.business.CPU;

public class ArithmeticOperations {
    private CPU cpu;

    public ArithmeticOperations(CPU cpu) {
        this.cpu = cpu;
    }

    public void add(int operand) {
        cpu.accumulator += cpu.memory.getData(operand);
    }

    public void subtract(int operand) {
        cpu.accumulator -= cpu.memory.getData(operand);
    }

    public void divide(int operand) {
        int data = cpu.memory.getData(operand);
        if (data != 0) {
            cpu.accumulator /= data;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        cpu.accumulator *= cpu.memory.getData(operand);
    }
}