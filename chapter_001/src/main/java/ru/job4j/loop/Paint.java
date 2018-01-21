package ru.job4j.loop;


import java.util.function.BiPredicate;

/**
 * class Paint.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class Paint {

    /**
     * Method rightTrl.
     * @param height Numeric value int, the height of the right triangle.
     * @return string representation sequence of characters.
     * @see Paint
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Method leftTrl.
     * @param height Numeric value int, the height of the left triangle.
     * @return string representation sequence of characters.
     * @see Paint
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Method pyramid.
     * @param height Numeric value int, the height of the pyramid.
     * @return string representation sequence of characters.
     * @see Paint
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Method loopBy
     * @param height Numeric value int, the height of the triangle.
     * @param weight Numeric value int, the weight of the triangle.
     * BiPredicate<Integer, Integer> The type of incoming data
     * @return string representation sequence of characters.
     * @see Paint
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}


