package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 * @author Alexander Rovnov
 * @version 1.1
 * @since 1.1
 */
public class MaxTest {
    /**
     * Test summation.
     */
    @Test
    public void whenOneSummationTreeThenFour() {
        Max max = new Max();
        int result = max.summation(1, 3);
        assertThat(result, is(4));
    }

    /**
     * Test multiplier
     */
    @Test
    public void whenTreeMultiplierTreeThenNine() {
        Max max = new Max();
        int result = max.multiplier(3, 3);
        assertThat(result, is(9));

    }

    /**
     * Test maximum
     */
    @Test
    public void whenFirstMaximumSecondThenMoreFirst() {
        Max max = new Max();
        int result = max.maximum(10, 5);
        assertThat(result, is(10));
    }

    /**
     * Test maximumOfThree
     */
    @Test
    public void whenFirstMaximumOfThreeSecondAndThirdThenMoreFirst() {
        Max max = new Max();
        int result = max.maximumOfThree(10, 5, 4);
        assertThat(result, is(10));
    }

}