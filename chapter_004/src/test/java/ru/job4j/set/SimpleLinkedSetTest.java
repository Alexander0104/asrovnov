package ru.job4j.set;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleLinkedSet.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleLinkedSetTest {

    private static SimpleLinkedSet<Integer> simpleSet;
    private static Iterator<Integer> itr;

    @Before
    public void beforeTest() {
        simpleSet = new SimpleLinkedSet<>();
        itr = simpleSet.iterator();
    }
    /**
     * Test_01.
     * add.
     */
    @Test
    public void whenAddOneThenTrue() {
        assertThat(simpleSet.add(10), is(true));
    }

    /**
     * Test_02.
     * Проверка что нельзя добавить повторяющийся элемент.
     */
    @Test
    public void whenAddOneOneTwoThenOneTwo() {
        simpleSet.add(10);
        assertThat(simpleSet.add(10), is(false));
        simpleSet.add(20);
        assertThat(itr.next(), is(10));
        assertThat(itr.next(), is(20));
    }

    /**
     * Test_03.
     */
    @Test
    public void whenAddOneTwoThenOneTwoTrueFalse() {
        simpleSet.add(10);
        simpleSet.add(20);
        assertThat(itr.next(), is(10));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(20));
        assertThat(itr.hasNext(), is(false));
    }
}