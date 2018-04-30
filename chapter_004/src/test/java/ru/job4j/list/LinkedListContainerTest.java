package ru.job4j.list;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class LinkedListContainer.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class LinkedListContainerTest {

    private static LinkedListContainer<Integer> linkedListContainer;

    @Before
    public void beforeTest() {
        linkedListContainer = new LinkedListContainer<>();
    }

    /**
     * Test_01.
     * add и get.
     */
    @Test
    public void whenAddTwoElementsThenTwo() {
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(linkedListContainer.get(1), is(2));
    }

    /**
     * Test_02.
     * removeFirst и removeLast.
     */
    @Test
    public void whenAddThreeElementsThenDelete() {
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        linkedListContainer.add(3);
        assertThat(linkedListContainer.removeFirst(), is(1));
        assertThat(linkedListContainer.removeLast(), is(3));
        assertThat(linkedListContainer.get(0), is(2));
    }

    /**
     * Test_03.
     */
    @Test
    public void whenInvokeHasNextThenCheckTheGetResultsIsGoingToBeTrue() {
        Iterator<Integer> itr = linkedListContainer.iterator();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(itr.hasNext(), is(true));
    }

    /**
     * Test_04.
     */
    @Test
    public void whenInvokeHasNextAndNextThenCheckTheGetResultsIsGoingToBeFalse() {
        Iterator<Integer> itr = linkedListContainer.iterator();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test_05.
     */
    @Test
    public void whenNotAddElementsInvokeHasNextThenFalse() {
        LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        Iterator<Integer> itr = linkedListContainer.iterator();
        assertThat(itr.hasNext(), is(false));
    }
}