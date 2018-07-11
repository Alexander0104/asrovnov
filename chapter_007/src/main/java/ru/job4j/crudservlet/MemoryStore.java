package ru.job4j.crudservlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * class MemoryStore implements Store.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class MemoryStore implements Store {

    private static final MemoryStore INSTANCE = new MemoryStore();
    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, User> store = new ConcurrentHashMap<>();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        final int userId = this.counter.incrementAndGet();
        user.setId(userId);
        this.store.put(userId, user);
    }

    @Override
    public void update(User user) {
        this.store.replace(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        this.store.remove(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.store.values());
    }

    @Override
    public User findById(int id) {
        return this.store.get(id);
    }

}
