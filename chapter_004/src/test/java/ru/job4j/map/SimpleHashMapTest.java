package ru.job4j.map;

import java.util.Iterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class SimpleHashMapTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleHashMapTest {

    private static SimpleHashMap<String, User> simpleHashMap;

    @Before
    public void beforeTest() {
        simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("Student", new User("Vladimir", 0,  null));
        simpleHashMap.insert("Engineer", new User("Alexander", 2, null));
    }

    /**
     * Test_01.
     * getSize.
     */
    @Test
    public void ifInsertTwoElementsInMapThenSizeTwo() {
        assertThat(simpleHashMap.getSize(), is(2));
    }

    /**
     * Test_02.
     * get.
     */
    @Test
    public void whenAddAddKeyAndValueThenGetUser() {
        SimpleHashMap<String, UserOverrideEqualsAndHashCode> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("first", new UserOverrideEqualsAndHashCode("Vladimir", 0,  null));
        assertThat(simpleHashMap.get("first"), is(new UserOverrideEqualsAndHashCode("Vladimir", 0,  null)));
    }

    /**
     * Test_03.
     * delete.
     */
    @Test
    public void whenAddTwoElementsInMapAndDeleteFirstThenResultTrue() {
        assertThat(simpleHashMap.delete("Student"), is(true));
    }

    /**
     * Test_04.
     * next и hasNext.
     */
    @Test
    public void whenAddKeyAndValueThenIteratorNextUserAndHasNextFalse() {
        SimpleHashMap<String, UserOverrideEqualsAndHashCode> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("first", new UserOverrideEqualsAndHashCode("Vladimir", 0,  null));
        Iterator iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is(new UserOverrideEqualsAndHashCode("Vladimir", 0,  null)));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test_05.
     * ConcurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowExceptionWhenModifyingAfterCreatingIterator() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>(2);
        simpleHashMap.insert(1, "one");
        simpleHashMap.insert(2, "two");
        Iterator iterator = simpleHashMap.iterator();
        simpleHashMap.delete(1);
        iterator.next();
        assertThat(iterator.next(), is("two"));
    }

    /**
     * Test_06.
     * NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddKeyAndValuesThenKeyAndValuesWithoutDuplicates() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>(2);
        simpleHashMap.insert(1, "one");
        simpleHashMap.insert(2, "two");
        simpleHashMap.insert(1, "two");
        Iterator iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is("two"));
        assertThat(iterator.next(), is("one"));
        iterator.next();
    }
}