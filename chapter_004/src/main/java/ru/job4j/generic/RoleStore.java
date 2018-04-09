package ru.job4j.generic;

/**
 * class RoleStore extends AbstractStore.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Конструктор класса Base с одним параметром.
     * @param simpleArray массив объектов Role.
     */
    public RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }
}
