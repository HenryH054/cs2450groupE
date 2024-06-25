package main.java.org.example.business;


public class ArithmeticOperations {
    private CPU cpu;
    private int accumulator;

    public ArithmeticOperations(CPU cpu) {
        this.cpu = cpu;
        accumulator = cpu.getAccumulator();
    }

    public void add(int operand) {
        cpu.setAccumulator(accumulator += cpu.getMemory().getData(operand));
    }

    public void subtract(int operand) {
        cpu.setAccumulator(accumulator -= cpu.getMemory().getData(operand));
    }

    public void divide(int operand) {
        int data = cpu.getMemory().getData(operand);
        if (data != 0) {
            cpu.setAccumulator(accumulator += data);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void multiply(int operand) {
        cpu.setAccumulator(accumulator *= cpu.getMemory().getData(operand));
    }
}