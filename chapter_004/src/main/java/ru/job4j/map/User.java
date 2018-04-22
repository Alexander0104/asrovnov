package ru.job4j.map;

import java.util.Calendar;

/**
 * class User.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор класса User.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Метод getName.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод getChildren.
     * @return children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Метод getBirthday.
     * @return birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
