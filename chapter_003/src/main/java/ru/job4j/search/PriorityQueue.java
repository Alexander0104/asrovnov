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
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority() > o2.getPriority()) {
                    return 1;
                } else if (o1.getPriority() < o2.getPriority()) {
                    return -1;
                }
                return 0;
            }
        });
        return this.tasks.poll();
    }
}
