package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SquareTest {
    /**
     * Test calculate.
     */
    @Test
    public void WhenAddCalculateTenThenTheArrayElementInSquare() {
        Square sq = new Square();

        int[] testCalculate = sq.calculate(10);
        int expectedResult[] = new int[10];
        for (int index = 0; index != expectedResult.length; index++) {
            expectedResult[index] = (int) Math.pow(index, 2);
        }
        assertArrayEquals(testCalculate, expectedResult);
        // или, но мне кажеться это не правильно, так как если массив состоит из 1000 элементов?
//        int expectedResult[] = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
//        assertThat(testCalculate, is(expectedResult));
    }
}
