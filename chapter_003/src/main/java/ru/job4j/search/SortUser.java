package ru.job4j.search;

import java.util.*;

/**
 * class SortUser.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class SortUser {

    /**
     * метод sort.
     * @param users список.
     * @return отсартированных по возрасту пользователей.
     */
    Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<User>();
        for (User user : users) {
            result.add(user);
        }
        return result;
    }
}

