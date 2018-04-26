package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class BubbleSortTest {

    /**
     * Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubsor = new BubbleSort();

        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] resultArray = bubsor.sort(array);
        int[] expectArray = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(resultArray, is(expectArray));
    }
}