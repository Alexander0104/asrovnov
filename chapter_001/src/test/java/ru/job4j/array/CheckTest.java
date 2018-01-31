package ru.job4j.array;

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
public class CheckTest {

    /**
     * Test_1 contains.
     * result = true
     */
    @Test
    public void WhenContainsAddStringOriginAndSubThenTrue() {
        Check check = new Check();
        boolean result = check.contains("Привет", "иве");
        assertThat(result, is(true));
    }

    /**
     * Test_2 contains.
     * result = true
     */
    @Test
    public void WhenContainsAddStringOriginAndSubThenFalse() {
        Check check = new Check();
        boolean result = check.contains("Java управляет интернетом", "Ja упр инт");
        assertThat(result, is(false));
    }
}