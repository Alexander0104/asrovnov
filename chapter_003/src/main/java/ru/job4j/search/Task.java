package ru.job4j.search;

/**
 * class Task.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Task {

    /**
     * Поля инициализируют Task.
     */
    private String desc;
    private int priority;

    /**
     * Конструктор класса Person.
     * @param desc описание задачи.
     * @param priority приоритет задачи.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Метод getDesc.
     * @return описание задачи.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Метод getPriority.
     * @return приоритет задачи.
     */
    public int getPriority() {
        return priority;
    }
}
