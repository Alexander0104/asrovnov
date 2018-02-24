package ru.job4j.array;

/**
 * class CheckSort.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class CheckSort {
    /**
     * Method check.
     * @param array type int.
     * @return return true if if array sort, false if not sorted.
     */
    public boolean check(int[] array) {
        boolean value = true;
        for (int index = 1; index != array.length; index++) {
            if (array[index - 1] > array[index]) {
                value = false;
                break;
            }
        }
        return value;
    }
}
