package ru.job4j.crudservlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * class MemoryStore implements Store.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class MemoryStore implements Store {

    private static final MemoryStore INSTANCE = new MemoryStore();
    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, User> store = new ConcurrentHashMap<>();
    private final Map<String, Integer> loginId = new ConcurrentHashMap<>();

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
        this.loginId.put(user.getLogin(), userId);
    }

    @Override
    public void update(User user) {
        User replacedUser = this.store.replace(user.getId(), user);
        this.loginId.remove(replacedUser.getLogin());
        this.loginId.put(user.getLogin(), user.getId());
    }

    @Override
    public void delete(int id) {
        User removedUser = this.store.remove(id);
        if (removedUser != null) {
            this.loginId.remove(removedUser.getLogin());
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.store.values());
    }

    @Override
    public User findById(int id) {
        return this.store.get(id);
    }

    @Override
    public User findByLogin(String login) {
        return this.store.get(this.loginId.get(login));
    }
}
