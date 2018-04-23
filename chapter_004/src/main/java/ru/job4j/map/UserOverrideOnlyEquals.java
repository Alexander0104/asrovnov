package ru.job4j.map;

import java.util.Calendar;

/**
 * class UserOverrideOnlyEquals extends User.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class UserOverrideOnlyEquals extends User {

    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор класса UserOverrideOnlyEquals.
     */
    public UserOverrideOnlyEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Переопределенный метод equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserOverrideOnlyEquals)) {
            return false;
        }
        UserOverrideOnlyEquals user = (UserOverrideOnlyEquals) o;
        if (user.getName().equals(this.name)
                && user.getChildren() == this.children
                && user.getName() == null
                && this.birthday == null) {
            return true;
        }
        return user.getName().equals(this.name)
                && user.getChildren() == this.children
                && user.getBirthday() == this.birthday;
    }

    /**
     * Метод hashCode использует стандартную реализацию.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

