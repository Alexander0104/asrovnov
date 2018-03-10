package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * class ValidateInputTest.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Test ask
     * Ввели данные которые не соответствуют пунктам меню.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "0"})
        );
        input.ask("Введите пункт меню: ", new int[] {0});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Ошибка ввода: Введите корректные данные%n")
                )
        );
    }

    /**
     * Test ask
     * Вышли из диапазона меню.
     */
    @Test
    public void whenNineInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"9", "0"})
        );
        input.ask("Введите пункт меню: ", new int[] {0});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Ошибка ввода: Введите пункт из меню%n")
                )
        );
    }
}