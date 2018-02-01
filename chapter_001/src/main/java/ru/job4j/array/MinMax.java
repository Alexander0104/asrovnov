package ru.job4j.array;
/**
 * class MinMax.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class MinMax {
    /**
     * Method check.
     * @param array type int.
     * @return return String min and max.
     */
    public String search(int[] array) {
        int min, max;
        min = max = array[0];
        for (int index = 0; index != array.length; index++) {
            if (array[index] < min) {
                min = array[index];
            }
            if (array[index] > max) {
                max = array[index];
            }
        }
        return min + "," + max;
    }
}
