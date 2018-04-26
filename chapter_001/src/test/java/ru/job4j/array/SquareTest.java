package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SquareTest {
    /**
     * Test calculate.
     */
    @Test
    public void whenAddCalculateTenThenTheArrayElementInSquare() {
        Square sq = new Square();

        int[] testCalculate = sq.calculate(10);
        int[] expectedResult = new int[10];
        for (int index = 0; index != expectedResult.length; index++) {
            expectedResult[index] = (int) Math.pow(index, 2);
        }
        assertArrayEquals(testCalculate, expectedResult);
    }
}
