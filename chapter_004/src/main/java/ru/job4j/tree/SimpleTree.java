package ru.job4j.tree;

import java.util.Optional;

/**
 * interface SimpleTree.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
