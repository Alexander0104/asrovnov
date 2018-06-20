package ru.job4j.crudservlet;

import java.util.Collection;
import java.util.Collections;

/**
 * class ValidateService.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ValidateService {

    private final static ValidateService INSTANCE  = new ValidateService();
    private final Store store = MemoryStore.getInstance();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public boolean add(User user) {
        if (store.findById(user.getId()) == null) {
            store.add(user);
            return true;
        }
        return false;
    }

    public boolean update(User user) {
        if (store.findById(user.getId()) != null) {
            store.update(user);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (store.findById(id) != null) {
            store.delete(id);
            return true;
        }
        return false;
    }

    public Collection<User> findAll() {
        if (!store.findAll().isEmpty()) {
            return store.findAll();
        }
        return Collections.EMPTY_LIST;
    }

    public User findById(int id) {
        return store.findById(id);
    }
}
