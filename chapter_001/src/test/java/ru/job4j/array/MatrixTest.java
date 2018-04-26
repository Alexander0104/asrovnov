package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class MatrixTest {

    /**
     * Test multiple.
     * comparison resultArray[9][9] =81 and expectArray[9][9] =81
     */
    @Test
    public void whenResultArrayIndexNineNineAndExpectArrayIndexNineNineThenEightyOne() {
        Matrix matrix = new Matrix();

        int[][] resultArray = matrix.multiple(10);
        int[][] expectArray = new int[10][10];
        expectArray[9][9] = 81;
        assertThat(resultArray[9][9], is(expectArray[9][9]));
    }

    /**
     * Test multiple.
     * comparison array resultArray and expectArray
     */
    @Test
    public void whenComparisonTwoArrayThenTrue() {
        Matrix matrix = new Matrix();

        int[][] resultArray = matrix.multiple(10);
        int[][] expectArray = new int[10][10];
        for (int indexA = 1; indexA != expectArray.length; indexA++) {
            for (int indexB = 1; indexB != expectArray.length; indexB++) {
                expectArray[indexA][indexB] = indexA * indexB;
            }
        }
        assertArrayEquals(resultArray, expectArray);
    }
}