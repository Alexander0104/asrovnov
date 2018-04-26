package ru.job4j.search;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test class ListCompare.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class ListCompareTest {

    private static ListCompare compare;

    @Before
    public void beforeTest() {
        compare = new ListCompare();
    }

    /**
     * Test_01.
     * Метод compare.
     */
    @Test
    public void whenStringsAreEqualThenZero() {
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    /**
     * Test_02.
     * Метод compare.
     */
    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    /**
     * Test_03.
     * Метод compare.
     */
    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    /**
     * Test_04.
     * Метод compare.
     */
    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    /**
     * Test_05.
     * Метод compare.
     */
    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }
}