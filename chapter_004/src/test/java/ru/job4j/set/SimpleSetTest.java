package ru.job4j.set;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleSet.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleSetTest {

    private static SimpleSet<Integer> simpleSet;
    private static Iterator<Integer> itr;

    @Before
    public void beforeTest() {
        simpleSet = new SimpleSet<>();
        itr = simpleSet.iterator();
    }
    /**
     * Test_01.
     * add.
     */
    @Test
    public void whenAddOneThenTrue() {
        assertThat(simpleSet.add(1), is(true));
    }

    /**
     * Test_02.
     * Проверка что нельзя добавить повторяющийся элемент.
     */
    @Test
    public void whenAddOneOneTwoThenOneTwo() {
        simpleSet.add(1);
        assertThat(simpleSet.add(1), is(false));
        simpleSet.add(2);
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
    }

    /**
     * Test_03.
     */
    @Test
    public void whenAddOneTwoThenOneTwoTrueFalse() {
        simpleSet.add(1);
        simpleSet.add(2);
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(false));
    }
}