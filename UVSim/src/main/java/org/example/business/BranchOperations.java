package main.java.org.example.business;

import main.java.org.example.business.CPU;

public class BranchOperations {
    private CPU cpu;

    public BranchOperations(CPU cpu) {
        this.cpu = cpu;
    }

    public void branch(int operand) {
        cpu.programCounter = operand;
    }

    public void branchNeg(int operand) {
        if (cpu.accumulator < 0) {
            cpu.programCounter = operand;
        }
    }

    public void branchZero(int operand) {
        if (cpu.accumulator == 0) {
            cpu.programCounter = operand;
        }
    }

    public void halt() {
        System.out.println("Program execution halted.");
        cpu.programCounter = -1;
    }
}
