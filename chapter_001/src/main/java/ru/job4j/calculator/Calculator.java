package ru.job4j.calculator;

/**
 * Class Calculator create elementary calculator.
 * @author Alexander Rovnov.
 * @version 1.0
 */
public class Calculator {

    /**
     * the arithmetic result.
     */
    private double result;

    /**
     * Method add.
     * @param first  Numeric floating-point value double-precision
     * @param second Numeric floating-point value double-precision
     * @see Calculator
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     * @param first  Numeric floating-point value double-precision
     * @param second Numeric floating-point value double-precision
     * @see Calculator
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * @param first  Numeric floating-point value double-precision
     * @param second Numeric floating-point value double-precision
     * @see Calculator
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     * @param first  Numeric floating-point value double-precision
     * @param second Numeric floating-point value double-precision
     * @see Calculator
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return the arithmetic result
     * @see Calculator
     */
    public double getResult() {
        return this.result;
    }
}
