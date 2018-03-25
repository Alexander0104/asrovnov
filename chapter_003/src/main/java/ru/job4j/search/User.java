package ru.job4j.search;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class User {

    /**
     * поля инициализируют User.
     */
    private int id;
    private String name;
    private String city;

    /**
     * конструктор класса User.
     * @param id имя.
     * @param name фамилия.
     * @param city телефон.
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
     * переопределенный метод toString.
     * @return возвращает строковое представление объект User.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + "city='" + city + '\''
                + '}';
    }
}
