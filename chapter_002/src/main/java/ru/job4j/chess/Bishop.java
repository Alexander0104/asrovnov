package ru.job4j.chess;

/**
 * class Bishop.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Bishop extends Figure {

    /**
     * Конструктор класса Bishop.
     * @param position позиция фигуры.
     */
    public Bishop(Cell position) {
        super(position);
    }
    /**
     * Способ перемещения фигуры.
     */
    FigureWay diagonal = new DiagonalWay();
    /**
     * Метод проверяющий правильность хода фигуры.
     * @return - список клеток ходов.
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        return diagonal.way(source, dest);
    }
    /**
     * Метод копирующий фигуру с новыми координатами.
     * @return - фигура с новыми координатами.
     */
    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
