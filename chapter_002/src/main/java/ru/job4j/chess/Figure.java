package ru.job4j.chess;

/**
 * abstract class Figure.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public abstract class Figure {

    /**
     * Поле хранящее позицию фигуры.
     */
    final Cell position;

    /**
     * Конструктор Figure.
     * @param position - позиция фигуры.
     */
    public Figure(Cell position) {
        this.position = position;

    }
    /**
     * Метод проверяющий правильность хода фигуры.
     * @return - список клеток ходов.
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Метод перемещающий фигуру на новое положение.
     * @param dest задает ячейку, куда следует пойти.
     */
    abstract Figure copy(Cell dest);
}
