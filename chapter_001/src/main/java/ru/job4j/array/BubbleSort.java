package ru.job4j.array;

/**
 * class BubbleSort.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class BubbleSort {

    /**
     * Method sort.
     * @param array array numeric value int.
     * @return returns a sorted array by bubble.
     */
    public int[] sort(int[]array) {
        int rev;
        for (int indexA = 1; indexA < array.length; indexA++) {
            for (int indexB = array.length - 1; indexB >= indexA; indexB--) {
                if (array[indexB - 1] > array[indexB]) {
                    rev = array[indexB - 1];
                    array[indexB - 1] = array[indexB];
                    array[indexB] = rev;
                }
            }
        }
        return array;
    }
}
