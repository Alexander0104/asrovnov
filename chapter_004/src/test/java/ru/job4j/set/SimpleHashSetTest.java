package ru.job4j.set;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleHashSet.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleHashSetTest {

    private static SimpleHashSet<Integer> simpleHashSet;

    @Before
    public void beforeTest() {
        simpleHashSet = new SimpleHashSet<>();
    }

    /**
     * Test.
     * add.
     */
    @Test
    public void whenAddTwoElementThenThreeFalse() {
        simpleHashSet.add(1);
        simpleHashSet.add(2);
        assertThat(simpleHashSet.contains(1), is(true));
        assertThat(simpleHashSet.contains(2), is(true));
        assertThat(simpleHashSet.contains(3), is(false));
    }

    /**
     * Test.
     * remove.
     */
    @Test
    public void whenDeleteOneThenContainsFalse() {
        simpleHashSet.add(1);
        assertThat(simpleHashSet.contains(1), is(true));
        simpleHashSet.remove(1);
        assertThat(simpleHashSet.contains(1), is(false));
    }

    /**
     * Test.
     * Проверка что нельзя добавить повторяющийся элемент.
     */
    @Test
    public void whenAddOneAndOneThenFalse() {
        simpleHashSet.add(1);
        assertThat(simpleHashSet.contains(1), is(true));
        assertThat(simpleHashSet.add(1), is(false));
    }

    /**
     * Test.
     * getSize.
     */
    @Test
    public void whenAddThreeElementThenSizeThree() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(3);
        simpleHashSet.add(1);
        simpleHashSet.add(2);
        simpleHashSet.add(3);
        assertThat(simpleHashSet.getSize(), is(3));
    }
}