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
public class MinMaxTest {
    /**
     * Test search.
     * result = "1,90".
     */
    @Test
    public void WhenAddSearchArrayThenMinAndMax() {
        int[] array = new int[]{20, 5, 1, 90, 70};
        MinMax minmax = new MinMax();
        String result = minmax.search(array);
        assertThat(result, is("1,90"));
    }
}