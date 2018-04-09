package ru.job4j.generic;

/**
 * class abstract Base.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public abstract class Base {

    private final String id;

    /**
     * Конструктор класса Base с одним параметром.
     * @param id id.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Метод getId.
     * @return id.
     */
    public String getId() {
        return id;
    }
}
