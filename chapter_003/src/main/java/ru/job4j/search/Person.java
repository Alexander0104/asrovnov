package ru.job4j.search;

/**
 * class Person.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Person {

    /**
     * поля инициализируют Person.
     */
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * конструктор класса Person.
     * @param name имя.
     * @param surname фамилия.
     * @param phone телефон.
     * @param address адрес.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * метод getName.
     * @return имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * метод getSurname.
     * @return фамилию человека.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * метод getPhone.
     * @return телефон человека.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * метод getAddress.
     * @return адрес человека.
     */
    public String getAddress() {
        return address;
    }
}
