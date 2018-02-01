package ru.job4j.array;

/**
 * class OnePlusTwo.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class OnePlusTwo {
    /**
     * Method newArray.
     * @param one type array int.
     * @param two type array int
     * @return return new three array.
     */
    public int[] newArray(int[] one, int[] two) {
        int[] three = new int[one.length + two.length];
        for (int out = 0; out!= one.length; out++) {
            three[out] = one[out];
            for (int in = one.length, index = 0; index != two.length; in++, index++) {
                three[in] = two[index];
            }
        }
        return three;
    }
}
