package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ArrayDuplicate {

    /**
     * Method remove.
     * @param array array String.
     * @return removing duplicates in the array.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out=0; out!=unique; out++) {
            for (int in=out+1; in!=unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique-1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
