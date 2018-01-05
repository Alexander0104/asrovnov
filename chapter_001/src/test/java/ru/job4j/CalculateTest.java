package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Rovnov
 * @version 0.0.1
 * @since 0.0.1
 */
 public class CalculateTest {
	/**
     * Test echo.
     */ 
	 @Test
	 public void whenTakeNameThenTreeEchoPlusName() {
		  String input = "Alexander Rovnov";
		  String expect = "Echo, echo, echo : Alexander Rovnov";
		  Calculate calc = new Calculate();
		  String result = calc.echo(input);
		  assertThat(result, is(expect));
	 }
 }