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
     * Test newArray.
     * result = 1, 2, 3, 4, 5, 6.
     */
    @Test
    public void WhenNewArrayAddArrayOneAndTwoThanNewThirdArray() {
        int[] one = {1, 2, 3};
        int[] two = {4, 5, 6};
        OnePlusTwo oneplustwo = new OnePlusTwo();
        int[] result = oneplustwo.newArray(one, two);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expected));

    }
}