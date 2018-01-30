package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TurnTest {

    /**
     * Test_1 back.
     * Odd array.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn tn = new Turn();

        int[] date = {5, 4, 3, 2, 1};
        int[] resultArray = tn.back(date);
        int[] expectArray = {1, 2, 3, 4, 5};
        assertThat(resultArray, is(expectArray));

    }

    /**
     * Test_2 back.
     * Event array.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn tn = new Turn();

        int[] date = {4, 1, 6, 2};
        int[] resultArray = tn.back(date);
        int[] expectArray = {2, 6, 1, 4};
        assertThat(resultArray, is(expectArray));

    }
}