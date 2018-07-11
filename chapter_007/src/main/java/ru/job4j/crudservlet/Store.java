package ru.job4j.crudservlet;

import java.util.List;

/**
 * interface Store.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public interface Store {

    /**
     * Метод add.
     * @param user пользователь.
     */
    void add(User user);

    /**
     * Метод update.
     * @param user пользователь.
     */
    void update(User user);

    /**
     * Метод delete.
     * @param id пользователя.
     */
    void delete(int id);

    /**
     * Метод findAll.
     */
    List<User> findAll();

    /**
     * Метод findById.
     * @param id пользователя.
     */
    User findById(int id);
}
