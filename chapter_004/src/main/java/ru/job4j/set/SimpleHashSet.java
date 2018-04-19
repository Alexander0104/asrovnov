package ru.job4j.set;

/**
 * class SimpleHashSet.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class SimpleHashSet<E> {

    private Object[] array;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Конструктор по умолчанию.
     * Инициализирует массив array с размером по умолчанию.
     */
    public SimpleHashSet() {
        this.array = new Object[DEFAULT_SIZE];
    }

    /**
     * Конструктор по умолчанию.
     * Инициализирует массив array с размером по умолчанию.
     */
    public SimpleHashSet(int size) {
        this.array = new Object[size + 1];
    }

    /**
     * Метод add.
     * Добовляет элементы в array.
     * @param element элемент который нужно добавить в array.
     * @return true если добавление успешно,
     *         false если добавление не произошло.
     */
    public boolean add(E element) {
        boolean result = false;
        resize();
        if (!contains(element)) {
            array[getHash(element)] = element;
            result = true;
            size++;
        }
        return result;
    }

    /**
     * Метод getSize.
     * @return Возвращает количество элементов в array
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Метод contains.
     * Проверяет содержит ли array заданный элемент.
     * @param element элемент который нужно проверить.
     * @return true если содержит.
     *         false если не содержит.
     */
    public boolean contains(E element) {
        boolean result = false;
        if (array[getHash(element)] != null && array[getHash(element)].equals(element)) {
            result = true;
        }
        return result;
    }

    /**
     * Метод remove.
     * Удаляет элемент из array.
     * @param element элемент который нужно удалить.
     * @return true если элемент удален из коллекции.
     *         false если элемент не найден в коллекции.
     */
    public boolean remove(E element) {
        boolean result = false;
        if (contains(element)) {
            array[getHash(element)] = null;
            result = true;
            size--;
        }
        return result;

    }

    /**
     * Метод resize.
     * Увеличивает размер таблицы и производит перехеширование
     * всех элементов, в соответствии с новым размером.
     */
    private void resize() {
        if (size == array.length) {
            int newSize = this.array.length * 2;
            Object[] newArray = new Object[newSize];
            for (Object element : this.array) {
                newArray[Math.abs(element.hashCode() % newArray.length)] = element;
            }
            this.array = newArray;
        }
    }

    /**
     * Метод getHash.
     * @param element заданный для вычисления хэш модуля элемент.
     * @return хэш модуль заданного элемента.
     */
    private int getHash(E element) {
        return Math.abs(element.hashCode() % this.array.length);
    }
}
