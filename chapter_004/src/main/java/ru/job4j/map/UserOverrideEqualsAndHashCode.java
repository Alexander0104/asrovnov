package ru.job4j.map;

import java.util.Calendar;

/**
 * class UserOverrideEqualsAndHashCode extends User.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class UserOverrideEqualsAndHashCode extends User {

    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор класса UserOverrideEqualsAndHashCode.
     */
    public UserOverrideEqualsAndHashCode(String name, int children, Calendar birthday) {
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
        if (!(o instanceof UserOverrideEqualsAndHashCode)) {
            return false;
        }
        UserOverrideEqualsAndHashCode user = (UserOverrideEqualsAndHashCode) o;
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
     * Переопределенный метод hashCode.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.children;
    }
}
