package ru.job4j.list;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class ArrayContainer.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class ArrayContainerTest {

    private static ArrayContainer<Integer> arrayContainer;

    @Before
    public void beforeTest() {
        arrayContainer = new ArrayContainer<>();
    }

    /**
     * Test_01.
     * add и get.
     */
    @Test
    public void whenAddMoreElementThenGetIndexThreeResultFour() {
        arrayContainer.add(1);
        arrayContainer.add(2);
        arrayContainer.add(3);
        arrayContainer.add(4);
        assertThat(arrayContainer.get(3), is(4));
    }

    /**
     * Test_02.
     */
    @Test
    public void whenAddTwoElementsInvokeNextThanTrue() {
        Iterator<Integer> itr = arrayContainer.iterator();
        arrayContainer.add(1);
        arrayContainer.add(2);
        itr.next();
        assertThat(itr.hasNext(), is(true));
    }
    /**
     * Test_03.
     */
    @Test
    public void whenAddTwoElementsInvokeNextAndNextThenFalse() {
        Iterator<Integer> itr = arrayContainer.iterator();
        arrayContainer.add(1);
        arrayContainer.add(2);
        itr.next();
        itr.next();
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test_04.
     */
    @Test
    public void whenNotAddElementsInvokeHasNextThanFalse() {
        ArrayContainer<Integer> arrayContainer = new ArrayContainer<>(0);
        Iterator<Integer> itr = arrayContainer.iterator();
        assertThat(itr.hasNext(), is(false));
    }
}