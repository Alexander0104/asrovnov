package ru.job4j.list;

/**
 * class CycleDetection.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class CycleDetection<E> {

    /**
     * Конструктор по умолчанию.
     */
    public CycleDetection() {
    }

    /**
     * Метод hasCycle.
     * Метод проверяет, что список содержит замыкания.
     * @param first узел из списка.
     * @return true если список содержит замыкание,
     *         false если список не содержит замыканий.
     */
    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        if (first != null) {
            Node<E> slow = first;
            Node<E> fast = first;
            while (!result && slow.next != null
                    && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow.equals(fast)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Class Node.
     */
    static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}
