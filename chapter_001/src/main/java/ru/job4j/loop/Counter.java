package ru.job4j.loop;

/**
 * Class Counter.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Counter {

    /**
     * Method add.
     * @param start  Numeric value int, start point
     * @param finish Numeric value int, finish point
     * @return возвращает вычисленную сумму четныx чисел в диапазоне от start до finish;
     * @see Counter
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if ((i % 2) == 0) {
                result += i;
            }
        }
        return result;
    }
}
