package ru.job4j.calculator;

import org.junit.Test;
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
public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenOneAddOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenFiveSubtractFourThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(5D, 4D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenSixDivTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */
    @Test
    public void whenTwoMultipleTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
