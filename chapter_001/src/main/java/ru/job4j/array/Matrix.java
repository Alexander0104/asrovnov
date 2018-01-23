package ru.job4j.array;

/**
 * class Matrix.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Matrix {

    /**
     * Method  multiple.
     * @param size Numeric value int, the size of a two-dimensional array.
     * @return multiplication table.
     * @see Matrix
     */
    public int[][] multiple(int size) {
        int array[][] = new int[size][size];

        for (int indexA=1; indexA!=size; indexA++) {
            for (int indexB=1; indexB!=size; indexB++){
                array[indexA][indexB] = indexA * indexB;
            }
        }
        return array;
    }
}
