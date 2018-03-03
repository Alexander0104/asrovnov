package ru.job4j.shape;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Paint.
 *
 * @author Alexander Rovnov
 * @version 1.1
 * @since 1.1
 */
public class PaintTest {

    private final PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * выполняет метод, то запуска тесты.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * выполняет метод, после запуска теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test draw(new Square).
     */
    @Test
    public void whenDrawSquare() {
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
    }

    /**
     * Test draw(new Triangle).
     */
    @Test
    public void whenDrawTriangle() {
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
    }
}