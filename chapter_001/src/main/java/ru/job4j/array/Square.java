package ru.job4j.array;

/**
 * class Square.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Square {

     /**
     * Method calculate.
     * @param bound Numeric value int, the length of the array.
     * @return the array elements in square.
     * @see Square
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index=1; index!=rst.length; index++) {
            rst[index] = (int) Math.pow(index, 2);
        }
        return rst;
    }
}
