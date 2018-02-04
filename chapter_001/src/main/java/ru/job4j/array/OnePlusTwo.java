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
        int i = 0, j = 0, index = 0;
        while (i < one.length && j < two.length){
            if (one[i] < two[j]) {
                three[index++] = one[i++];
            } else
                three[index++] = two[j++];
        }
        while (i < one.length) {
            three[index++] = one[i++];
        }
        while (j < two.length) {
            three[index++] = two[j++];
        }
        return three;
    }
}
