package ru.job4j.tree;

import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class BST.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class BST<E extends Comparable<E>> implements Iterable<E> {

    private Node<E> root;
    private int size;
    private int modCount;

    /**
     * Метод createRoot.
     * Добавление корневого элемента.
     * @param value элемент.
     * @return true.
     */
    private boolean createRoot(E value) {
        root = new Node<>(value, null);
        return true;
    }

    /**
     * Метод add.
     * Добавляет элемент в дерево.
     * @param value элемент.
     * @return успешность добавления
     */
    public boolean add(E value) {
        boolean result;
        result = root == null ? createRoot(value) : createChild(value);
        if (result) {
            modCount++;
            size++;
        }
        return result;
    }

    /**
     * Метод createChildren.
     * Добавляю элемент, который не является корневым.
     * @param value элемент.
     * @return успешность добавления
     */
    private boolean createChild(E value) {
        Node<E> currentNode = root;
        Node<E> parent = null;
        boolean success = true;
        do {
            if (value.compareTo(currentNode.value) == 0) {
                success = false;
                break;
            } else {
                parent = currentNode;
                if (value.compareTo(currentNode.value) < 0) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
        } while (currentNode != null);
        if (success) {
            currentNode = new Node<>(value, parent);
            if (parent.value.compareTo(currentNode.value) > 0) {
                parent.left = currentNode;
            } else {
                parent.right = currentNode;
            }
        }
        return success;
    }

    /**
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int innerModCount = modCount;
            private Node<E> next = null;
            private int innerCount = 0;

            @Override
            public boolean hasNext() {
                return innerCount < size;
            }

            @Override
            public E next() {
                checkException();
                if (next == null) {
                    next = getSmall(root);
                }
                E result = next.value;
                innerCount++;
                initNext();
                return result;
            }

            private void checkException() {
                if (innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (innerCount == size) {
                    throw new NoSuchElementException();
                }
            }

            private void initNext() {
                if (next.right != null) {
                    next = getSmall(next.right);
                } else {
                    E currentValue = next.value;
                    do {
                        next = next.parent;
                    } while (hasNext() && currentValue.compareTo(next.value) > 0);
                }
            }

            private Node<E> getSmall(Node<E> start) {
                Node<E> currentItem = start;
                Node<E> result = currentItem;
                if (currentItem != null) {
                    while (currentItem != null) {
                        result = currentItem;
                        currentItem = currentItem.left;
                    }
                }
                return result;
            }
        };
    }

    /**
     * class Node.
     */
    private static class Node<E> {

        E value;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        private Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
