package ru.job4j.max;

/**
 * Class Max.
 * Максимум из двух чисел
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
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
     * Method comparison.
     * @param first  Numeric value int
     * @param second Numeric value int
     * @return comparison first and second
     * @see Max
     */
    public String comparison(int first, int second) {
        return first > second ? "Первое больше второго": "Второй больше первого";
    }
}