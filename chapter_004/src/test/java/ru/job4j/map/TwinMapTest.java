package ru.job4j.map;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class TwinMapTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TwinMapTest {

    private static TwinMap twinMap;

    @Before
    public void beforeTest() {
        twinMap = new TwinMap();
    }

    /**
     * Test_01.
     * Когда hashCode и equals не переопределены.
     */
    @Test
    public void whenCreateTwoUserAndPutInMapThenEqualsResultFalse() {
        User first = new User("Name", 1, null);
        User second = new User("Name", 1, null);
        System.out.println(String.format("First hashCode: %s", first.hashCode()));
        System.out.println(String.format("Second hashCode: %s", second.hashCode()));
        System.out.println(first.equals(second));
        assertThat(first.equals(second), is(false));
        twinMap.put(first, 1);
        twinMap.put(second, 1);
        System.out.println(twinMap.getMap());
    }

    /**
     * Test_02.
     * Когда переопределен только hashCode.
     */
    @Test
    public void whenCreateTwoUserAndPutInMapThenOneHashCodeBytEqualsResultFalse() {
        UserOverrideOnlyHashCode first = new UserOverrideOnlyHashCode("Name", 2, null);
        UserOverrideOnlyHashCode second = new UserOverrideOnlyHashCode("Name", 2, null);
        System.out.println(String.format("First hashCode: %s", first.hashCode()));
        System.out.println(String.format("Second hashCode: %s", second.hashCode()));
        System.out.println(first.equals(second));
        assertThat(first.equals(second), is(false));
        twinMap.put(first, 2);
        twinMap.put(second, 2);
        System.out.println(twinMap.getMap());
    }

    /**
     * Test_03.
     * Когда переопределен только equals.
     */
    @Test
    public void whenCreateTwoUserAndPutInMapThenDifferentHashCodeBytEqualsResultTrue() {
        UserOverrideOnlyEquals first = new UserOverrideOnlyEquals("Name", 3, null);
        UserOverrideOnlyEquals second = new UserOverrideOnlyEquals("Name", 3, null);
        System.out.println(String.format("First hashCode: %s", first.hashCode()));
        System.out.println(String.format("Second hashCode: %s", second.hashCode()));
        System.out.println(first.equals(second));
        assertThat(first.equals(second), is(true));
        twinMap.put(first, 3);
        twinMap.put(second, 3);
        System.out.println(twinMap.getMap());
    }

    /**
     * Test_04.
     * Когда переопределен equals и hashCode.
     */
    @Test
    public void whenCreateTwoUserAndPutInMapThenDifferentHashCodeByt() {
        UserOverrideEqualsAndHashCode first = new UserOverrideEqualsAndHashCode("Name", 4, null);
        UserOverrideEqualsAndHashCode second = new UserOverrideEqualsAndHashCode("Name", 4, null);
        System.out.println(String.format("First hashCode: %s", first.hashCode()));
        System.out.println(String.format("Second hashCode: %s", second.hashCode()));
        System.out.println(first.equals(second));
        assertThat(first.equals(second), is(true));
        twinMap.put(first, 4);
        twinMap.put(second, 4);
        System.out.println(twinMap.getMap());
    }
}