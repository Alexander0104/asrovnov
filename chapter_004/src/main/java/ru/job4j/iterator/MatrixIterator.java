package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class MatrixIterator.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class MatrixIterator implements Iterator {

    /**
     * Массив для хранения элементов.
     */
    private int[][] array;

    /**
     * Индекс строки.
     */
    private int row;

    /**
     * Индекс столбца.
     */
    private int column;

    /**
     * Конструктор класса EvenIterator с одним параметром.
     * @param array массив.
     */
    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    /**
     * Метод hasNext.
     * @return true если в коллекции еще имеются элементы
     *          и false если елементов нет.
     */
    @Override
    public boolean hasNext() {
        return this.row != this.array.length;
    }

    /**
     * Метод next.
     * @return возвращает следующий элемент в итерации.
     */
    @Override
    public Object next() {
        if (this.row >= this.array.length) {
            throw new NoSuchElementException();
        }
        int result = this.array[this.row][this.column++];
        if (this.column >= this.array[this.row].length) {
            this.column = 0;
            this.row++;
        }
        return result;
    }
}
