package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class StartGameChess.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class StartGameChessTest {

    /**
     * Тест_1
     * Проверяет перемещение фигуры.
     */
    @Test
    public void whenSetFigureToPositionThenFigureANewPosition() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell source = new Cell(1, 7);
        Cell dest = new Cell(2, 8);
        FigureWay diagonal = new DiagonalWay();
        Cell[] result = diagonal.way(source, dest);
        Cell[] expected = new Cell[]{new Cell(2, 8), null, null, null, null, null, null};
        assertThat(result, is(expected));
    }
    /**
     * Тест_2
     * Проверяет возможность хода на ошибки.
     */
    @Test
    public void whenErrorCheckingThenTrue() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        new StartGameChess(board).play();
        Figure bishop = new Bishop(new Cell(2, 7));
        Cell dest = new Cell(1, 6);
        board.figures[bishop.position.x][bishop.position.y] = bishop;
        assertThat(board.move(bishop.position, dest), is(true));
    }
    /**
     * Тест_3
     * Проверяет может ли фигура перемещаться по этому пути.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenErrorCheckingThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        new StartGameChess(board).play();
        Figure bishop = new Bishop(new Cell(2, 7));
        Cell dest = new Cell(2, 6);
        board.figures[bishop.position.x][bishop.position.y] = bishop;
        assertThat(board.move(bishop.position, dest), is(new ImpossibleMoveException()));
    }
    /**
     * Тест_4
     * Проверяет есть ли фигура в заданной клетке.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenErrorCheckingThenFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        new StartGameChess(board).play();
        Figure bishop = new Bishop(new Cell(0, 7));
        Cell source = new Cell(2, 7);
        Cell dest = new Cell(1, 5);
        board.figures[bishop.position.x][bishop.position.y] = bishop;
        assertThat(board.move(source, dest), is(new FigureNotFoundException()));
    }
    /**
     * Тест_5
     * Проверяет есть ли препятствия на пути фигуры.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenErrorCheckingThenOccupiedWayException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        new StartGameChess(board).play();
        Figure bishopM = new Bishop(new Cell(1, 3));
        Figure bishopO = new Bishop(new Cell(2, 4));
        Cell dest = new Cell(3, 5);
        board.figures[bishopO.position.x][bishopO.position.y] = bishopO;
        board.figures[bishopM.position.x][bishopM.position.y] = bishopM;
        assertThat(board.move(bishopM.position, dest), is(new OccupiedWayException()));
    }

}