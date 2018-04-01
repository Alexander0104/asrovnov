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
        int size = this.tasks.size();
        for (int index = 0; index != size; index++) {
            if (task.getPriority() <= tasks.get(index).getPriority()) {
                this.tasks.add(index, task);
                break;
            }
        }
        this.tasks.add(task);
    }

    /**
     * Метод take.
     * @return возвращает приоритетную задачу.
     */
    public Task take() {
        return tasks.poll();
    }
}
