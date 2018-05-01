package ru.job4j.tree;

import java.util.*;

/**
 * class Tree.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Корень дерева.
     */
    private Node<E> root;

    /**
     * Счетчик изменений коллекции.
     */
    private int modCount;

    /**
     * Конструктор класса Tree.
     * @param element корень
     */
    public Tree(E element) {
        Node<E> node = new Node<>(element);
        this.root = node;
    }

    /**
     * Добавляет элемент в дерево.
     * @param parent корень.
     * @param child добавляемый элемент.
     * @return true - если добавление прошло успешно.
     *         false - если не удалось добавить элемент.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> foundParent = findBy(parent);
        boolean result = false;
        if (foundParent.isPresent()) {
            foundParent.get().add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
    }

    /**
     * Производит поиск заданного элемента.
     * @param value заданный элемент.
     * @return узел, заданного элемента.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Метод isBinary.
     * Метод проверяет, дерево является бинарным или нет.
     * @return true - если дерево бинарное.
     *         false - если дерево не бинароное.
     */
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() <= 2) {
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * @return итератора.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> nodes;
            private int expectedModCount = modCount;


            private Queue<Node<E>> getAll() {
                if (nodes == null) {
                    this.nodes = new LinkedList<>();
                    addChild(root);
                }
                return this.nodes;
            }

            private void addChild(Node<E> currentNode) {
                for (Node<E> child : currentNode.leaves()) {
                    this.nodes.offer(child);
                    addChild(child);
                }
            }

            @Override
            public boolean hasNext() {
                return !getAll().isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.nodes.poll().getValue();
            }
        };
    }
}
