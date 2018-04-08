package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class EvenIterator.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class EvenIterator implements Iterator {

    /**
     * Массив для хранения элементов.
     */
    private int[] array;

    /**
     * Индекс.
     */
    private int index;

    /**
     * Конструктор класса EvenIterator с одним параметром.
     * @param array массив.
     */
    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * Метод hasNext.
     * @return true если элемент четный и false если елемент не четный.
     */
    @Override
    public boolean hasNext() {
        boolean even = false;
        while (this.index != this.array.length) {
            if (this.array[this.index] % 2 == 0) {
                even = true;
                break;
            }

            index++;
        }
        return even;
    }

    /**
     * Метод next.
     * @return возвращает следующий элемент в итерации.
     */
    @Override
    public Object next() {
        hasNext();
        if (this.index >= this.array.length) {
            throw new NoSuchElementException();
        }
        return this.array[this.index++];
    }
}

