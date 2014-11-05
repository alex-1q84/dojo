package me.changhai.algorithms.ch1;

/**
 * Created by bl02515 on 14/11/3.
 */
public class ResizingArrayStack<ITEM> {
    private Object[] data;
    private int n = 0;

    public ResizingArrayStack(int capacity) {
        this.data = new Object[capacity];
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

    public void push(ITEM item) {
        data[n++] = item;
    }

    public ITEM pop() {
        return (ITEM) data[--n];
    }
}
