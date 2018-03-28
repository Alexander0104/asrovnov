package ru.job4j.search;

import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;

/**
 * class PriorityQueue.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class PriorityQueue {

    /**
     * Очередь с приоритетом задачь.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод put.
     * Метод вставляет в нужную позицию элемент.
     * @param task задача
     */
    public void put(Task task) {
        this.tasks.add(task);
    }

    /**
     * Метод take.
     * @return возвращает приоритетную задачу.
     */
    public Task take() {
        Task obj1;
        Task obj2;
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = tasks.size() - 1; j > i; j--) {
                obj1 = tasks.get(i);
                obj2 = tasks.get(j);
                if (obj1.getPriority() > obj2.getPriority()) {
                    tasks.set(j, obj1);
                    tasks.set(i, obj2);
                }
            }
        }
        return this.tasks.poll();
    }
}
