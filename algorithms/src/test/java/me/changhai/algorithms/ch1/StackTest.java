package me.changhai.algorithms.ch1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Integer>();
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
        Stack<String> strStack = new Stack<String>();
        strStack.push("a");
        assertEquals("a", strStack.pop());
    }

    @Test
    public void test_iterator() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Iterator<Integer> iterator = stack.iterator();
        assertThat(iterator, is(notNullValue()));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
}