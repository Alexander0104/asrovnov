package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleStack.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleStackTest {

    /**
     * Test.
     * poll и push.
     */
    @Test
    public void whenAddElementThenLifo() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}