package ru.job4j.search;

import java.util.Comparator;

/**
 * class ListCompare.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ListCompare implements Comparator<String> {

    /**
     * метод compare.
     * @param left строка.
     * @param right строка.
     * @return Отрицательное целое число, нуль или положительное целое число,
     *         если строка меньше, равна или больше указанной.
     */
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        int result = 0;
        for (int index = 0; index < size; index++) {
            result = Integer.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
