package ru.job4j.list;

/**
 * interface SimpleContainer extends Iterable.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public interface SimpleContainer<E> extends Iterable<E> {

    /**
     * Метод add.
     * Добовляет элементы в container.
     * @param element элемент который нужно вставить в container.
     */
    void add(E element);

    /**
     * Метод get.
     * Получение значения из массива.
     * @param index значение позиции в массиве.
     * @return элемент соответствующий индексу.
     */
    E get(int index);
}
