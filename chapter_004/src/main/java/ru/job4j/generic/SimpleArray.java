package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class SimpleArray.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class SimpleArray<T> implements Iterable<T> {

    /**
     * Массив для хранения объектов,.
     */
    private Object[] array;

    private int size = 0;

    /**
     * Конструктор класса SimpleArray с одним параметром.
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Метод add.
     * @param model добовляемый объект.
     */
    public void add(T model) {
        this.array[size++] = model;

    }

    /**
     * Метод add.
     * @param index ячейка массива куда добавляеься объект.
     * @param model добовляемый объект.
     */
    public void set(int index, T model) {
        array[index] = model;
    }

    /**
     * Метод delete.
     * @param index индекс удаляемого элемента.
     */
    public void delete(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.size--;
    }

    /**
     * Метод get
     * @param index индекс ячейки массива.
     * @return объект.
     */
    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * Метод get
     * @return размер массива.
     */
    public int size() {
        return this.size;
    }

    /**
     * Метод iterator.
     * @return итератор типа <T>.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int position;

            /**
             * Метод hasNext.
             * @return true если в коллекции еще имеются
             *         элементы иначе логическое значение false.
             */
            @Override
            public boolean hasNext() {
                return this.position < size();
            }

            /**
             * Метод next.
             * @return возвращает следующий элемент в итерации.
             */
            @Override
            public T next() {
                if (this.position >= size()) {
                    throw new NoSuchElementException();
                }
                return get(this.position++);
            }
        };
    }
}