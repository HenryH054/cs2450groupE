package main.java.org.example.data;

public class Memory {
    private int[] data;

    public Memory(int size) {
        this.data = new int[size];
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
