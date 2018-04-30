package ru.job4j.tree;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Iterator;

/**
 * Test class TreeTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TreeTest {

    private  Tree<Integer> tree;

    @Before
    public void beforeTest() {
        tree = new Tree<>(1);
    }

    /**
     * Test_01.
     * add и findBy.
     */
    @Test
    public void when6ElFindLastThen6() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    /**
     * Test_02.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    /**
     * Test_03.
     * Iterator.
     */
    @Test
    public void whenTestIterator() {
        tree.add(1, 1);
        tree.add(1, 2);
        Iterator<Integer> itr = tree.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
    }
}