package ru.job4j.shape;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Square.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SquareTest {

    /**
     * Test draw.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                                                .append("++++")
                                                .append("+  +")
                                                .append("+  +")
                                                .append("++++")
                                                .toString()));
    }
}