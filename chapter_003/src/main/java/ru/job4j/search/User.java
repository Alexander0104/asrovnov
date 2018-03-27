package ru.job4j.search;

import java.util.Objects;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {

    /**
     * поля инициализируют User.
     */
    private int id;
    private String name;
    private int age;
    private String city;

    /**
     * конструктор класса User с 2-мя параметрами.
     * @param name имя.
     * @param age возраст пользователя.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * конструктор класса User с 3-мя параметрами.
     * @param id пользователя.
     * @param name имя.
     * @param city город.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    /**
     * метод getId.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * метод getName.
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * метод getCity.
     * @return город.
     */
    public String getCity() {
        return city;
    }

    /**
     * метод getAge.
     * @return возраст.
     */
    public int getAge() {
        return age;
    }

    /**
     * Переопределенный метод toString.
     * @return возвращает строковое представление объект User.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + "city='" + city + '\''
                + "age='" + age + '}';
    }

    /**
     * Переопределенный метод compareTo.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.getAge(), o.getAge());
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
        return id == user.id
                && age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(city, user.city);
    }

    /**
     * Переопределенный метод hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, city);
    }
}
