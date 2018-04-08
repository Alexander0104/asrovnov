package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class IteratorOfIterators.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class IteratorOfIterators {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> inIterator = it.next();

            /**
             * Метод hasNext.
             * @return true если элемент есть и false если элементов нет.
             */
            @Override
            public boolean hasNext() {
                if (!inIterator .hasNext() && it.hasNext()) {
                    inIterator  = it.next();
                }
                return inIterator.hasNext();
            }


            /**
             * Метод next.
             * @return возвращает следующий элемент в итерации.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inIterator.next();
            }
        };
    }
}
