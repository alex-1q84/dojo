package me.changhai.algorithms.ch1;

/**
 * Created by hailxl@gmail.com on 14/11/3.
 */
public class ResizingArrayStack<ITEM> {
    private Object[] data;
    private int n = 0;

    /**
     * 使用所给参数初始化一个指定大小的stack
     * 注意：如果所给初始化值小于1则使用默认初始值10
     * @param initialCapacity 初始stack 大小
     */
    public ResizingArrayStack(int initialCapacity) {
        if (initialCapacity < 1) {
            this.data = new Object[10];
        }else{
            this.data = new Object[initialCapacity];
        }
    }

    public ResizingArrayStack() {
        this(10);
    }

    private void resize(int length) {
        Object[] tempData = new Object[length];
        System.arraycopy(data, 0, tempData, 0, n);
        this.data = tempData;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void push(ITEM item) {
        if (n == data.length) {
            resize(data.length * 2);
        }
        data[n++] = item;
    }

    public ITEM pop() {
        ITEM item = (ITEM) data[--n];
        //这么做保证剩余可用空间总是现有元素数量的一倍，不至于浪费过多内存
        if (n > 0 && n == data.length / 4) {
            resize(data.length / 2);
        }
        return item;
    }
}
