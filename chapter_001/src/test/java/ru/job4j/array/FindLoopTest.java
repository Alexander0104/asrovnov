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
public class FindLoopTest {

    /**
     * Test_1 indexOf.
     * expected 2.
     */
    @Test
    public void indexOfAddArrayFiveElementsAndLookElementThatTwo() {
        FindLoop fl = new FindLoop();

        int[] date = new int[5];
        for (int index=0; index!=date.length; index++){
            date[index] = index;
        }
        int result = fl.indexOf(date, 2);
         assertThat(result, is(2));

    }

    /**
     * Test_2 indexOf.
     * expected -1.
     */
    @Test
    public void indexOfAddArrayFiveElementsAndLookElementThatMinusOne() {
        FindLoop fl = new FindLoop();

        int[] date = new int[5];
        for (int index=0; index!=date.length; index++){
            date[index] = index;
        }
        int result = fl.indexOf(date, 8);
        assertThat(result, is(-1));
    }
}