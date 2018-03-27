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
     *
     * @param users список.
     * @return TreeSet отсартированный по возрасту пользователей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * метод sortNameLength.
     * @param users список.
     * @return List отсартированнй по длине имени пользователей.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    /**
     * метод sortByAllFields.
     * @param users список.
     * @return List отсартированнй по длине имени и возрасту пользователей.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return users;
    }
}

