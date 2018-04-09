package ru.job4j.generic;

/**
 * class UserStore extends AbstractStore.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Конструктор класса Base с одним параметром.
     * @param simpleArray массив объектов User.
     */
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}
