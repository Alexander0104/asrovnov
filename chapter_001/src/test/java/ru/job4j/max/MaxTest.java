package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
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
     * Test comparison
     */
    @Test
    public void whenFirstMaxSecondThenMoreSecond() {
        Max max = new Max();
        int result =max.maximum(max.summation(1, 3), max.multiplier(3, 3));
        assertThat(result, is(9));
    }

}