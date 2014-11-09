package me.changhai.algorithms.ch1;

import java.util.Iterator;

/**
 * a simple stack implementation use link list
 * Created by bl02515 on 14/11/9.
 */
public class Stack<ITEM> implements Iterable<ITEM> {
    private Node<ITEM> first = null;

    private int size = 0;

    private static class Node<NODE> {
        NODE val;

        Node<NODE> next;
    }

    public void push(ITEM val) {
        Node<ITEM> oldFirst = first;
        first = new Node<ITEM>();
        first.val = val;
        first.next = oldFirst;
        size += 1;
    }

    public ITEM pop() {
        Node<ITEM> oldFirst = first;
        first = oldFirst.next;
        size -= 1;
        return oldFirst.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<ITEM> {
        private Node<ITEM> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public ITEM next() {
            ITEM item = current.val;
            current = current.next;
            return item;
        }
    }
}
