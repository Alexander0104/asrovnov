package ru.job4j.array;

/**
 * class Turn.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Turn {

    /**
     * Method back.
     * @param array array numeric value int.
     * @return reverse array.
     */
    public int[] back(int[] array) {
        int rev;

        for (int index = 0; index < array.length / 2; index++) {
            rev = array[array.length - index - 1];
            array[array.length - index - 1] = array[index];
            array[index] = rev;
        }
        return array;
    }
}
