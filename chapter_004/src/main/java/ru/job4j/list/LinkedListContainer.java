package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class LinkedListContainer implements Iterable.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class LinkedListContainer<E> implements Iterable<E> {

    private int size = 0;
    private Node<E> last;
    private Node<E> first;

    /**
     * Конструктор по умолчанию.
     */
    public LinkedListContainer() {
    }

    /**
     * Метод add.
     * Добавляет элемент в список
     * @param element элемент который нужно добавить в список.
     */
    public void add(E element) {
        linkLast(element);
    }

    /**
     * Метод get
     * Получает заначение из списка по индексу.
     * @param index значение позиции в списке.
     * @return элемент соответствующий индексу.
     * @throws IllegalArgumentException недопустимый или несоответствующий параметр.
     * @throws ArrayIndexOutOfBoundsException если индекс больше фактического.
     */
    public E get(int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return node(index).item;
    }

    /**
     * Метод node.
     * @param index позиция в списке.
     * @return значения элементов.
     */
    private Node<E> node(int index) {
        Node<E> entryNode;
        if (index < (this.size >> 1)) {
            entryNode = this.first;
            for (int i = 0; i < index; i++) {
                entryNode = entryNode.next;
            }
        } else {
            entryNode = this.last;
            for (int i = this.size - 1; i > index; i--) {
                entryNode = entryNode.prev;
            }
        }
        return entryNode;
    }

    /**
     * Удаляет первый объект из списка.
     * @return удаляемый объект.
     */
    public E removeFirst() {
        E result = this.first.item;
        if (size > 1) {
            this.first.next.prev = null;
            this.first = this.first.next;
        } else {
            this.first = null;
            this.last = null;
        }
        size--;
        return result;
    }

    /**
     * Удаляет последний объект из списка.
     * @return удаляемый объект.
     */
    public E removeLast() {
        E result = this.last.item;
        if (size > 1) {
            this.last.prev.next = null;
            this.last = this.last.prev;
        } else {
            this.first = null;
            this.last = null;
        }
        size--;
        return result;
    }

    /**
     * Метод linkLast.
     * @param element элемент.
     */
    private void linkLast(E element) {
        final Node<E> lastNode = this.last;
        final Node<E> newNode = new Node<>(lastNode, element, null);
        this.last = newNode;
        if (lastNode != null) {
            lastNode.next = newNode;
        } else {
            this.first = newNode;
        }
        size++;
    }

    /**
     * Class Node.
     * @param <E> параметр определенный при создании класса.
     */
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    /**
     * Переопределенный метод iterator из интерфейса Iterable.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int count = 0;
            @Override
            public boolean hasNext() {
                return (count < size) && (last != null);
            }

            @Override
            public E next() {
                count++;
                Node<E> nextNode = first;

                if (nextNode != null && count > 1) {
                    nextNode = nextNode.next;
                }

                if (nextNode == null) {
                    throw new NoSuchElementException();
                }
                return nextNode.item;
            }
        };
    }
}
