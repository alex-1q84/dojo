package me.changhai.algorithms.ch1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ResizingArrayStackTest {

    ResizingArrayStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new ResizingArrayStack<Integer>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_not_empty() throws Exception {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        stack.push(1);
        stack.push(1);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush() throws Exception {
        stack.push(2);
        stack.push(1);
        assertEquals(2, stack.size());
        int item = stack.pop();
        assertEquals(1, item);
        item = stack.pop();
        assertEquals(2, item);
    }

    @Test
    public void testPop() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        assertEquals("size should 3", 3, stack.size());
        int item = stack.pop();
        assertEquals(1, item);
        item = stack.pop();
        assertEquals(2, item);
        item = stack.pop();
        assertEquals(3, item);
        assertEquals(0, stack.size());
    }

    @Test
    public void test_string_stack() throws Exception {
        ResizingArrayStack<String> strStack = new ResizingArrayStack<String>();
        strStack.push("a");
        assertEquals("a", strStack.pop());
    }

    @Test
    public void test_init_stack_by_capacity() {
        ResizingArrayStack stack = new ResizingArrayStack(0);
        try {
            stack.push(1);
            fail("should throw an exception because of the stack capacity is 0");
        } catch (IndexOutOfBoundsException e) {
            //Just expect this option will throw this exception
        }
    }
}