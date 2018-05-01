package ru.job4j.tree;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Test class TreeTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class BSTTest {

    private BST<Integer> tree;

    @Before
    public void beforeTest() {
        tree = new BST<>();
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(2);
    }

    /**
     * Test_01.
     */
    @Test
    public void whenAddElementsAndUseIterator() {
        Iterator<Integer> itr = tree.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(3));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(4));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(5));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test_02.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddElementAndUseThroeNSEException() {
        BST<Integer> tree = new BST<>();
        tree.add(1);
        Iterator<Integer> itr = tree.iterator();
        assertThat(itr.next(), is(1));
        itr.next();
    }

    /**
     * Test_03.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementsAfterAddItr() {
        BST<Integer> tree = new BST<>();
        tree.add(1);
        Iterator<Integer> itr = tree.iterator();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(false));
        tree.add(2);
        itr.next();
    }
}