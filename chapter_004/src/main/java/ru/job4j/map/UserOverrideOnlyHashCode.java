package ru.job4j.map;

import java.util.Calendar;

/**
 * class UserOverrideOnlyHashCode extends User.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class UserOverrideOnlyHashCode extends User {

    private String name;
    private int children;

    /**
     * Конструктор класса UserOverrideOnlyHashCode.
     */
    public UserOverrideOnlyHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
        this.name = name;
        this.children = children;
    }

    /**
     * Переопределенный метод hashCode.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.children;
    }
}
