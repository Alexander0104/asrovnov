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
public class CheckSortTest {
    /**
     * Test_1 check.
     * result = true
     */
    @Test
    public void whenCheckAddSortArrayThenTrue() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        CheckSort cs = new CheckSort();
        boolean result = cs.check(array);
        assertThat(result, is(true));
    }
    /**
     * Test_2 check.
     * result = false
     */
    @Test
    public void whenCheckAddNotSortArrayThenFalse() {
        int[] array = new int[]{3, 5, 4, 1, 2};
        CheckSort cs = new CheckSort();
        boolean result = cs.check(array);
        assertThat(result, is(false));
    }
}