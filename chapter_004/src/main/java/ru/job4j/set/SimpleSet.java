package ru.job4j.set;

import ru.job4j.list.ArrayContainer;
import java.util.Iterator;

/**
 * class SimpleSet implements Iterable.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class SimpleSet<E> implements Iterable<E> {

    /**
     * Хранилище.
     */
    private ArrayContainer<E> container = new ArrayContainer<E>();

    /**
     * Метод add.
     * Добовляет элементы в container.
     * @param element элемент который нужно добавить в container.
     * @return true если добавление успешно,
     *         false если добавление не произошло.
     */
    public boolean add(E element) {
        for (E check : this.container) {
            if (check.equals(element)) {
                return false;
            }
        }
        this.container.add(element);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
