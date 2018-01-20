package ru.job4j.loop;

/**
 * class Board.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Board {

    /**
     * Method add.
     * @param width Numeric value int, the width of the Board.
     * @param height Numeric value int, the height of the Board.
     * @return string representation sequence of characters.
     * @see Board
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (((i + j) % 2) == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
