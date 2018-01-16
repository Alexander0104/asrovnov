package ru.job4j.max;

/**
 * Class Max.
 * Максимум из двух чисел
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class Max {

    /**
     * Method summation.
     * @param first  Numeric value int
     * @param second Numeric value int
     * @return summation first and second
     * @see Max
     */
    public int summation(int first, int second) {
        return first + second;
    }

    /**
     * Method multiplier.
     * @param first  Numeric value int
     * @param second Numeric value int
     * @return multiplier first and second
     * @see Max
     */
    public int multiplier(int first, int second) {
        return first * second;
    }
    /**
     * Method maximum.
     * @param first  Numeric value int
     * @param second Numeric value int
     * @return the maximum of two numbers
     * @see Max
     */
    public int maximum(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method maximum.
     * @param first  Numeric value int
     * @param second Numeric value int
     * @param third Numeric value int
     * @return the maximum of three numbers
     * @see Max
     */
    public int maximumOfThree(int first, int second, int third) {
        return maximum(maximum(first, second), third);
    }
}