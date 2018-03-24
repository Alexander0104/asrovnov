package ru.job4j.search;

import org.junit.Test;
import org.junit.Before;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class ConvertList.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class ConvertListTest {

    private static ConvertList convertList;

    @Before
    public void beforeTest() {
        convertList = new ConvertList();
    }

    /**
     * Test.
     * toList.
     */
    @Test
    public void whenToListAddArrayThenArrayList() {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
    };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(convertList.toList(array), is(expected));

    }

    /**
     * Test.
     * toArray add two rows.
     */
    @Test
    public void whenToArrayAddListAndTwoRowsThenArrayTwoLine() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int[][] expected = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        assertThat(convertList.toArray(list, 2), is(expected));
    }

    /**
     * Test.
     * toArray add tree rows.
     */
    @Test
    public void whenToArrayAddListAndTreeRowsThenArrayTreeLine() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int[][] expected = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        assertThat(convertList.toArray(list, 3), is(expected));
    }
}