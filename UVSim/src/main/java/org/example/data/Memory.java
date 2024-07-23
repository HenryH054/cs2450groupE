package org.example.data;
/**
 * The Memory class simulates a simple memory storage with a fixed size array.
 * @author Damon Morgan
 */
public class Memory {
    public final static int SIZE = 250;
    private int[] data;

    /**
     * Constructs a Memory object with a fixed size array of 100 elements.
     */
    public Memory() {
        this.data = new int[SIZE];
    }

    /**
     * Retrieves the data at the specified index.
     *
     * @param index the index of the data to retrieve
     * @return the data at the specified index
     */
    public int getData(int index) {
        return data[index];
    }

    /**
     * Sets the data at the specified index after truncating the value to four digits.
     *
     * @param operand the index at which to set the data
     * @param value the value to set
     */
    public void setData(int operand, int value) {
        data[operand] = truncateToSixDigits(value);
    }

    public int size() {
        return data.length;
    }

    /**
     * Truncates a number to six digits.
     *
     * @param number the number to truncate
     * @return the truncated number
     */
    private int truncateToSixDigits(int number) {
        // Convert the number to a string
        String numStr = String.valueOf(Math.abs(number));
        String sign = number < 0 ? "-" : "";

        // If the number has more than four digits, get the first four digits
        if (numStr.length() > 6) {
            numStr = numStr.substring(0, 6);
        }

        // Convert back to an integer and return
        return Integer.parseInt(sign + numStr);
    }

    /**
     * Clears all data in the memory by setting each element to 0.
     */
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }
}
