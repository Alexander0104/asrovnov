package ru.job4j.loop;

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
public class BoardTest {

    /**
     * Test_1 paint.
     */
    @Test
        public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
            Board board = new Board();
            String result = board.paint(3, 3);
            final String line = System.getProperty("line.separator");
            String expected = String.format("x x%s x %sx x%s", line, line, line);
            assertThat(result, is(expected));
        }

    /**
     * Test_2 paint.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(4, 5);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}