package ru.job4j.list;

/**
 * class SimpleStack.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleStack<E> {

    private LinkedListContainer<E> storage = new LinkedListContainer<>();

    /**
     * Удаляет последний элемент из очереди.
     * @return удаленный элемент из головы очереди.
     */
    public E poll() {
        return storage.removeLast();
    }

    /**
     * Вводит элемент в очередь.
     * @param value элемент.
     */
    public void push(E value) {
        storage.add(value);
    }
}
