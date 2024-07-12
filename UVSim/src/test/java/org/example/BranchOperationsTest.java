package org.example.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


class BranchOperationsTest {

    @Mock
    private CPU mockCpu;

    private BranchOperations branchOperations;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        branchOperations = new BranchOperations(mockCpu);
    }

    @Test
    public void testBranch() {
        int operand = 100;
        branchOperations.branch(operand);
        verify(mockCpu).setProgramCounter(operand);
    }

    @Test
    public void testBranchNeg() {
        when(mockCpu.getAccumulator()).thenReturn(-1);
        int operand = 100;
        branchOperations.branchNeg(operand);
        verify(mockCpu).setProgramCounter(operand);
    }

    @Test
    public void testBranchNegNotTaken() {
        when(mockCpu.getAccumulator()).thenReturn(1);
        int operand = 100;
        branchOperations.branchNeg(operand);
        verify(mockCpu, never()).setProgramCounter(anyInt());
    }

    @Test
    public void testBranchZero() {
        when(mockCpu.getAccumulator()).thenReturn(0);
        int operand = 100;
        branchOperations.branchZero(operand);
        verify(mockCpu).setProgramCounter(operand);
    }

    @Test
    public void testBranchZeroNotTaken() {
        when(mockCpu.getAccumulator()).thenReturn(1);
        int operand = 100;
        branchOperations.branchZero(operand);
        verify(mockCpu, never()).setProgramCounter(anyInt());
    }

    @Test
    public void testHalt() {
        branchOperations.halt();
        verify(mockCpu).setProgramCounter(-1);
    }
}
