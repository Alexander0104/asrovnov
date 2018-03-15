package ru.job4j.chess;

/**
 * interface FigureWay.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public interface FigureWay {

    /**
     * Метод проверяет правильность хода.
     * @return список клеток ходов.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
}
