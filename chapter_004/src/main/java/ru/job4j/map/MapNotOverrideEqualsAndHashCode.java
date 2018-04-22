package ru.job4j.map;

import java.util.HashMap;

/**
 * class public class MapNotOverrideEqualsAndHashCode
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class MapNotOverrideEqualsAndHashCode {

    private HashMap<User, Object> map = new HashMap<>();

    public void put(User user, Object object) {
        map.put(user, object);
    }

    public HashMap<User, Object> getMap() {
        return map;
    }
}
