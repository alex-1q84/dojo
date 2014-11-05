package me.changhai.algorithms.ch1;

/**
 * Created by bl02515 on 14/11/3.
 */
public class ResizingArrayStack {
    private int[] data;
    private int n = 0;

    public ResizingArrayStack(int capacity) {
        this.data = new int[capacity];
    }

    public ResizingArrayStack() {
        this(10);
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void push(int item) {
        data[n++] = item;
    }

    public int pop() {
        return data[--n];
    }
}
