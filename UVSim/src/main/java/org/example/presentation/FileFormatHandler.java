package org.example.presentation;
import java.util.ArrayList;
import java.util.List;

public class FileFormatHandler {

    public static boolean isOldFormat(List<String> instructions) {
        for (String instruction : instructions) {
            if (instruction.substring(1).length() < 6) {
                return false;
            }
        }
        return true;
    }

    public static List<String> convertToNewFormat(List<String> oldInstructions) {
        List<String> newInstructions = new ArrayList<>();
        for (String instruction : oldInstructions) {
            if (instruction.length() <= 2) {
                newInstructions.add(String.format("%06d", Integer.parseInt(instruction)));
            } else {
                int value = Integer.parseInt(instruction);
                if (value / 100 >= 10 && value / 100 <= 43) {
                    // It's a function code
                    newInstructions.add(String.format("%03d%03d", value / 100, value % 100));
                } else {
                    // It's a number
                    newInstructions.add(String.format("%06d", value));
                }
            }
        }
        return newInstructions;
    }

    public static List<Integer> fourToSixDigitConverter(List<Integer> instructions) {
       List<Integer> newInstructions = new ArrayList<>();
        for (Integer instruction : instructions) {
            int operation = instruction / 100;
            int operand = instruction % 100;
            boolean isOperation = (operation == 10 || operation == 11 || operation == 20 || operation == 21
                    || operation == 31 || operation == 32 || operation == 40
                    || operation == 41 || operation == 42 || operation == 43);
            if(isOperation) {
                String stringOperation = String.format("%03d", operation);
                String stringOperand = String.format("%03d", operand);
                String stringInstruction = stringOperation + stringOperand;
                instruction = Integer.parseInt(stringInstruction);
                newInstructions.add(instruction);
            }else{
                newInstructions.add(instruction);
            }
        }


        return newInstructions;
    }

    public static boolean isOldFormatInteger(List<Integer> oldInstructions) {

        for (Integer instruction : oldInstructions) {
            String intstructionString = String.valueOf(instruction);
            if (intstructionString.substring(1).length() > 4) {
                return false;
            }
        }
        return true;

    }
}
