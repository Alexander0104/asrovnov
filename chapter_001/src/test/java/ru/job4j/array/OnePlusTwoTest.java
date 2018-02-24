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
public class OnePlusTwoTest {
    /**
     * Test_1 newArray.
     * result = 1, 2, 3, 4, 5, 6.
     */
    @Test
    public void whenNewArrayAddArrayOneAndTwoThanNewThirdArray() {
        int[] one = {1, 2, 3};
        int[] two = {4, 5, 6};
        OnePlusTwo oneplustwo = new OnePlusTwo();
        int[] result = oneplustwo.newArray(one, two);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expected));

    }
    /**
     * Test_2 newArray.
     * result = 1, 1, 2, 3, 4, 5, 5, 6.
     */
    @Test
    public void whenNewArrayAddArrayOneAndTwoThanNewThirdSortArray() {
        int[] one = {1, 2, 3, 5};
        int[] two = {1, 4, 5, 6};
        OnePlusTwo oneplustwo = new OnePlusTwo();
        int[] result = oneplustwo.newArray(one, two);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6};
        assertThat(result, is(expected));
    }
}