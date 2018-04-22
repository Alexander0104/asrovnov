package ru.job4j.map;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class MapNotOverrideEqualsAndHashCodeTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class MapNotOverrideEqualsAndHashCodeTest {

    private static MapNotOverrideEqualsAndHashCode mapNotOverrideEqualsAndHashCode;

    @Before
    public void beforeTest() {
        mapNotOverrideEqualsAndHashCode = new MapNotOverrideEqualsAndHashCode();
    }

    /**
     * Test.
     */
    @Test
    public void whenCreateTwoUserAndPutInMapThenEqualsResultFalse() {
        User first = new User("Name", 1, null);
        User second = new User("Name", 1, null);
        System.out.println(String.format("First hashCode: %s", first.hashCode()));
        System.out.println(String.format("Second hashCode: %s", second.hashCode()));
        System.out.println(first.equals(second));
        assertThat(first.equals(second), is(false));
        mapNotOverrideEqualsAndHashCode.put(first, 1);
        mapNotOverrideEqualsAndHashCode.put(second, 1);
        System.out.println(mapNotOverrideEqualsAndHashCode.getMap());
    }
}