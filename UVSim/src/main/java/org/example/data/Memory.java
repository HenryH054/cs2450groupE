package org.example.data;

public class Memory {
    public int[] data;

    public Memory() {
        this.data = new int[100];
    }

    public int getData(int index) {
        return data[index];
    }

    public void setData(int operand, int value) {
        data[operand] = truncateToFourDigits(value);
    }

    private int truncateToFourDigits(int number) {
        // Convert the number to a string
        String numStr = String.valueOf(Math.abs(number));
        String sign = number < 0 ? "-" : "";

        // If the number has more than four digits, get the first four digits
        if (numStr.length() > 4) {
            numStr = numStr.substring(0, 4);
        }

        // Convert back to an integer and return
        return Integer.parseInt(sign + numStr);
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }
}
