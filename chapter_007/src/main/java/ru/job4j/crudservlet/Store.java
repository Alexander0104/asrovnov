package ru.job4j.crudservlet;

import java.util.Collection;

/**
 * interface Store.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public interface Store {

    void add(User user);

    void update(User user);

    void delete(int id);

    Collection<User> findAll();

    User findById(int id);
}
