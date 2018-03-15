package ru.job4j.chess;

/**
 * class StartGameChess.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class StartGameChess {

    /**
     * Поле хранящее доску для игры.
     */
    Board board;

    /**
     * Конструктор класса StartGameChess.
     * @param board - доска для фигур.
     */
    public StartGameChess(Board board) {
        this.board = board;
    }

    /**
     * Метод проверяющий правильность хода фигуры и перемещающий её в случае выполнения условий.
     */
    public void play() {
        Figure bishop = new Bishop(new Cell(0, 2));
        Cell nextPosition = new Cell(2, 4);
        board.figures[bishop.position.x][bishop.position.y] = bishop;
        try {
            board.move(bishop.position, nextPosition);
        } catch (ImpossibleMoveException ime) {
            System.out.println("Вы не можите так перемещаться.");
        } catch (FigureNotFoundException fne) {
            System.out.println("Фигура не найдена.");
        } catch (OccupiedWayException owe) {
            System.out.println("На пути есть фигура.");
        }
    }
}
