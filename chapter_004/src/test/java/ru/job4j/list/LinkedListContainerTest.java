package ru.job4j.list;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class LinkedListContainer.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class LinkedListContainerTest {

    private static SimpleContainer<Integer> linkedListContainer;

    @Before
    public void beforeTest() {
        linkedListContainer = new LinkedListContainer<>();
    }

    /**
     * Test_01.
     * add и get.
     */
    @Test
    public void whenAddTwoElementsThanTwo() {
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(linkedListContainer.get(1), is(2));
    }

    /**
     * Test_02.
     */
    @Test
    public void whenInvokeHasNextThanCheckTheGetResultsIsGoingToBeTrue() {
        Iterator<Integer> itr = linkedListContainer.iterator();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(itr.hasNext(), is(true));
    }

    /**
     * Test_03.
     */
    @Test
    public void whenInvokeHasNextAndNextThanCheckTheGetResultsIsGoingToBeFalse() {
        Iterator<Integer> itr = linkedListContainer.iterator();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test_04.
     */
    @Test
    public void whenNotAddElementsInvokeHasNextThanFalse() {
        SimpleContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        Iterator<Integer> itr = linkedListContainer.iterator();
        assertThat(itr.hasNext(), is(false));
    }
}