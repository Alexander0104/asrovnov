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
        for (int index = 0; index < left.length() && index < right.length(); index++) {
            if (left.charAt(index) != right.charAt(index)) {
                return left.charAt(index) < right.charAt(index) ? -1 : 1;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
