package ru.job4j.loop;

/**
 * class Factorial.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Factorial {

    /**
     * Method add.
     * @param n Numeric value int,
     * @return возвращает вычисленный факториал аргумента n, если n равен 0, возвращает 1;
     * @see Factorial
     */
    public int calc(int n) {
        int result = 1;
        for (int i = result; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
