package org.example.business;
import org.example.business.CPU;

public class BranchOperations {
    private CPU cpu;

    public BranchOperations(CPU cpu) {
        this.cpu = cpu;
    }

    public void branch(int operand) {
        cpu.setProgramCounter(operand);
    }

    public void branchNeg(int operand) {
        if (cpu.getAccumulator() < 0) {
            cpu.setProgramCounter(operand);
        }
    }

    public void branchZero(int operand) {
        if (cpu.getAccumulator() == 0) {
            cpu.setProgramCounter(operand);
        }
    }

    public void halt() {
        System.out.println("Program execution halted.");
        cpu.setProgramCounter(-1);
    }
}
