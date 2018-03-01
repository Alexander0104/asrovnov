package ru.job4j.shape;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Paint.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class PaintTest {

    /**
     * Test draw(new Square).
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                                                                .append("++++")
                                                                .append("+  +")
                                                                .append("+  +")
                                                                .append("++++")
                                                                .append(System.lineSeparator())
                                                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Test draw(new Triangle).
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                                                                .append("   +   ")
                                                                .append("  + +  ")
                                                                .append(" +   + ")
                                                                .append("+++++++")
                                                                .append(System.lineSeparator())
                                                                .toString()
                )
        );
        System.setOut(stdout);
    }
}