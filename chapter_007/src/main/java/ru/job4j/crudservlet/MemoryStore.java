package ru.job4j.crudservlet;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * class MemoryStore implements Store.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class MemoryStore implements Store {

    private static final MemoryStore INSTANCE = new MemoryStore();
    private Map<Integer, User> store = new ConcurrentHashMap<>();

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        if (store.containsKey(user.getId())) {
            store.put(user.getId(), user);
        }
    }

    @Override
    public void delete(int id) {
        if (store.containsKey(id)) {
            store.remove(id);
        }
    }

    @Override
    public Collection<User> findAll() {
        return store.values();
    }

    @Override
    public User findById(int id) {
        return store.get(id);
    }

}
