package ru.job4j.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * class UserConvert.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class UserConvert {

    private List<User> users = new ArrayList<User>();

    /**
     * метод add.
     * долбавляет пользователя в список.
     * @param user пользователь.
     */
    public void add(User user) {
          this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

    /**
     * метод process.
     * @param users список.
     * @return HashMap.
     */
    public HashMap<Integer, User> process(List<User> users) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User user : users) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
