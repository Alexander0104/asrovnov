package ru.job4j.bank;

import java.util.Objects;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {

    /**
     * Поля инициализируют User.
     */
    private String name;
    private String pasport;

    /**
     * Конструктор класса User с 2-мя параметрами.
     * @param name имя.
     * @param pasport паспорт пользователя.
     */
    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }


    /**
     * Метод getName.
     * @return имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод getPasport.
     * @return паспорт.
     */
    public String getPasport() {
        return this.pasport;
    }

    /**
     * Переопределенный метод toString.
     * @return возвращает строковое представление объект User.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + this.name + '\''
                + "pasport='" + this.pasport + '}';
    }

    /**
     * Переопределенный метод equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(pasport, user.pasport);
    }

    /**
     * Переопределенный метод hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, pasport);
    }

    /**
     * Переопределенный метод compareTo.
     */
    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}
