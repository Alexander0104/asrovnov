package ru.job4j.generic;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleArray.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleArrayTest {

    private static SimpleArray<Integer> simple;

    @Before
    public void beforeTest() {
        simple = new SimpleArray<>(3);
        simple.add(1);
        simple.add(2);
        simple.add(3);
    }

    /**
     * Test.
     * delete.
     */
    @Test
    public void whenAddTreeElementsThenSizeThree() {
        assertThat(simple.size(), is(3));
    }

    /**
     * Test.
     * set.
     */    @Test
    public void whenSetAddIndexZeroAndModelTwoThenIndexZeroInArrayTwo() {
         simple.set(0, 2);
         assertThat(simple.get(0), is(2));
    }

    /**
     * Test.
     * delete.
     */
    @Test
    public void whenDeleteAddIndexThreeThenSizeArrayTwo() {
        simple.delete(0);
        assertThat(simple.size(), is(2));
    }

    /**
     * Test.
     * get.
     */
    @Test
    public void whenGetAddZeroThenOne() {
        assertThat(simple.get(0), is(1));
    }

    /**
     * Test.
     * size.
     */
    @Test
    public void size() {
        assertThat(simple.size(), is(3));
    }

    /**
     * Test.
     * iterator.
     */
    @Test
    public void whenIterator() {
        Iterator<Integer> it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}