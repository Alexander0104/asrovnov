package ru.job4j.map;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * class SimpleHashMap implements Iterable.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleHashMap<K, V> implements Iterable {

    private static final int DEFAULT_SIZE = 16;
    private Node[] container;
    private int size;
    private int modCount;

    /**
     * Конструктор SimpleHashMap.
     * Инициализирует хранилище с размером по умолчанию.
     */
    public SimpleHashMap() {
        this.container = new Node[DEFAULT_SIZE];
    }

    /**
     * Конструктор SimpleHashMap с одним параметром.
     * Инициализирует хранилище с заданым размером.
     * @param size размер container.
     */
    public SimpleHashMap(int size) {
        this.container = new Node[size];
    }

    /**
     * Метод getSize.
     * @return колличество элементов в container.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Метод insert.
     * Добавляет пары ключ - значение в хранилище.
     * @param key ключ.
     * @param value значение.
     * @return true - если хранилище не содержит добавляемого ключа.
     *         false - если хранилище уже содержит добавляемый ключ.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int factor = this.container.length;
        if (this.container[position(key)] == null) {
            if (this.size > factor * 2 / 3) {
                resize();
            }
            this.container[position(key)] = new Node(key, value);
            this.size++;
            result = true;
            this.modCount++;
        }
        return result;
    }

    /**
     * Метод get.
     * @param key ключ.
     * @return Значения ключа, если коллекция содержит такой ключ.
     */
    public V get(K key) {
        int index = hash(key, this.container.length);
        if (this.container[index] != null && this.container[index].key.equals(key)) {
            return (V) this.container[index].value;
        }
        return null;
    }

    /**
     * Метод delete.
     * Удаляет пару ключ - значение из хранилища.
     * @param key ключ заданной для удаления.
     * @return true - если пара удалена из коллекции.
     *         false - если ключ не найден в коллекции.
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = this.position(key);
        if (this.container[index] != null
                && this.container[index].getKey().equals(key)) {
            this.container[index] = null;
            result = true;
            this.size--;
            this.modCount++;
        }
        return result;
    }

    /**
     * Метод position.
     * Вычисляет хэш модуль ключа, в зависимости от размеров хэш таблицы.
     * @param key заданный для вычисления хэш модуля ключ.
     */
    private int position(K key) {
        return Math.abs(key.hashCode() % this.container.length);
    }

    /**
     * Метод hash.
     * Вычисляет хэш модуль ключа.
     * @param key заданный для вычисления хэш модуля ключ.
     * @param newSize размер хэш таблицы, для вычисления хэш модуля.
     */
    private int hash(K key, int newSize) {
        return key.hashCode() % newSize;
    }

    /**
     * Метод resize.
     * Увеличивает размер таблицы и производит перехеширование.
     */
    private void resize() {
        Node<K, V>[] newContainer = (Node<K, V>[]) new Node[this.container.length * 2];
        for (Node<K, V> entry : this.container) {
            if (entry != null) {
                newContainer[hash(entry.getKey(), newContainer.length)] = entry;
            }
        }
        this.container = newContainer;
    }

    /**
     * @return Iterator для обхода коллекции.
     */
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = this.index; i < container.length; i++) {
                    if (container[i] != null) {
                        result = true;
                        break;
                    } else {
                        index++;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (index == container.length) {
                    throw new NoSuchElementException();
                }
                hasNext();
                return (V) container[index++].value;
            }
        };
    }

    /**
     * Класс Node.
     * @param <K> Параметризованный тип ключа.
     * @param <V> Параметризованный тип значения.
     */
    private static class Node<K, V> {

        private K key;
        private V value;

        /**
         * Конструктор Node с двумя параметрами.
         * @param key ключ.
         * @param value значение.
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
}
