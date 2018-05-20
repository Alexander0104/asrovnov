package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * class ArrayContainer implements Iterable.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class ArrayContainer<E> implements Iterable<E> {

    @GuardedBy("this")
    private Object[] container;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private int index = 0;

    /**
     * Конструктор по умолчанию.
     * Инициализирует массив container с размером по умолчанию.
     */
    public ArrayContainer() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор класса ArrayContainer с одним параметром.
     * @param size размер массива.
     */
    public ArrayContainer(int size) {
        if (size > 0) {
            this.container = new Object[size];
        } else if (size == 0) {
            this.container = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод add.
     * Добовляет элементы в container.
     * @param element элемент который нужно вставить в container.
     * @throws ArrayIndexOutOfBoundsException если индекс больше фактического.
     */
    public synchronized void add(E element) throws ArrayIndexOutOfBoundsException {
        checkSize(this.index + 1);
        this.container[this.index++] = element;
    }

    /**
     * Метод get.
     * Получение значения из массива.
     * @param index значение позиции в массиве.
     * @return элемент соответствующий индексу.
     * @throws IllegalArgumentException недопустимый или несоответствующий параметр.
     * @throws ArrayIndexOutOfBoundsException если индекс больше фактического.
     */
    public synchronized E get(int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return (E) this.container[index];
    }

    /**
     * Метод checkSize.
     * @param nextIndex следующий индекс который будет проверен.
     */
    private synchronized void checkSize(int nextIndex) {
        if (this.container.length - 1 == nextIndex && this.container.length >= DEFAULT_CAPACITY) {
            int nexSize = (this.container.length * 3) / 2 + 1;
            this.container = Arrays.copyOf(this.container, nexSize);
        }
    }

    /**
     * Переопределенный метод iterator из интерфейса Iterable.
     * @return Iterator.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {

            int count = 0;
            @Override
            public boolean hasNext() {
                return count < container.length - (container.length - index);
            }

            @Override
            public E next() {
                return (E) container[count++];
            }
        };
    }
}