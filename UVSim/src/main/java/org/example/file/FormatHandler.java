package org.example.file;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the conversion of file formats by processing instructions.
 * @author Damon Morgan
 */
public class FormatHandler {

    public static List<Integer> convertInstructionsToNewFormat(List<Integer> instructions) {
       List<Integer> newInstructions = new ArrayList<>();
        for (Integer instruction : instructions) {
            boolean isOperation = isFunctionalCode(instruction);
            if(isOperation) {
                convertInstruction(instruction, newInstructions);
            }else{
                newInstructions.add(instruction);
            }
        }
        return newInstructions;
    }

    /**
     * Determines if the given instruction is a functional code.
     *
     * @param instruction Integer representing the instruction.
     * @return true if the instruction is a functional code, false otherwise.
     */
    public static boolean isFunctionalCode(int instruction) {
        int operation = instruction / 100;
        return (operation == 10 || operation == 11 || operation == 20
                || operation == 21 || operation == 30 || operation == 31
                || operation == 32 || operation == 33 || operation == 40
                || operation == 41 || operation == 42 || operation == 43);
    }

    /**
     * Converts an instruction to the new format and adds it to the list.
     *
     * @param instruction Integer representing the instruction to be converted.
     * @param newInstructions List of integers where the converted instruction is added.
     */
    public static void convertInstruction(Integer instruction, List<Integer> newInstructions) {
        int operation = instruction / 100;
        int operand = instruction % 100;
        String stringOperation = String.format("%03d", operation);
        String stringOperand = String.format("%03d", operand);
        String stringInstruction = stringOperation + stringOperand;
        instruction = Integer.parseInt(stringInstruction);
        newInstructions.add(instruction);
    }
}
