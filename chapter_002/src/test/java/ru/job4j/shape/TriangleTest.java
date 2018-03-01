package ru.job4j.shape;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Triangle.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TriangleTest {

    /**
     * Test draw.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                                                .append("   +   ")
                                                .append("  + +  ")
                                                .append(" +   + ")
                                                .append("+++++++")
                                                .toString()));
    }
}