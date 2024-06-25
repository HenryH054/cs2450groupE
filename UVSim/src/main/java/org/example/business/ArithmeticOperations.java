package main.java.org.example.business;

import main.java.org.example.business.CPU;


public class ArithmeticOperations {
    private CPU cpu;

    public ArithmeticOperations(CPU cpu) {
        this.cpu = cpu;
    }

    public void add(int operand) {
        int num = cpu.getAccumulator();
        cpu.setAccumulator(num += cpu.getMemory().getData(operand));
    }

    public void subtract(int operand) {
        int num = cpu.getAccumulator();
        cpu.setAccumulator(num -= cpu.getMemory().getData(operand));
    }

    public void divide(int operand) {
        int data = cpu.getMemory().getData(operand);
        if (data != 0) {
            int num = cpu.getAccumulator();
            cpu.setAccumulator(num += data);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        int num = cpu.getAccumulator();
        cpu.setAccumulator(num *= cpu.getMemory().getData(operand));
    }
}