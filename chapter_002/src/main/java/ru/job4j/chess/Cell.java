package ru.job4j.chess;

/**
 * class Cell.
 * Хранение координат фигур
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Cell {

    /**
     * Поле хранящее координату x.
     */
    int x;

    /**
     * Поле хранящее координату y.
     */
    int y;

    /**
     * Конструктор.
     * @param x координата.
     * @param y координата.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод переопределяющий equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell cell = (Cell) obj;
        if (x != cell.x) {
            return false;
        }
        return y == cell.y;
    }
}
