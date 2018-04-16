package ru.job4j.list;

/**
 * class SimpleQueue.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleQueue<E> {

    private LinkedListContainer<E> storage = new LinkedListContainer<>();

    /**
     * Удаляет первый элемент из очереди.
     * @return удаленный элемент из головы очереди.
     */
    public E poll() {
        return storage.removeFirst();
    }

    /**
     * Вводит элемент в очередь.
     * @param value элемент.
     */
    public void push(E value) {
        storage.add(value);
    }
}
