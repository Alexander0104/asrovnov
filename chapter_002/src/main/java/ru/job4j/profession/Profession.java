package ru.job4j.profession;
/**
 * base class Profession.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Profession {
    private String name, surname;

    /**
     * default constructor.
     */
    Profession() {
    }

    /**
     * constructor have one param.
     * @param name type String
     */
    Profession(String name) {
        this.name = name;
    }

    /**
     * constructor have two param.
     * @param name type String
     * @param surname type String
     */
    Profession(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * method getName.
     * @return name type String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * method getSurname.
     * @return surname type String.
     */
    public String getSurname() {
        return this.surname;
    }
}
