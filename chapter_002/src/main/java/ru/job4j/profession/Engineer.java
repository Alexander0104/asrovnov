package ru.job4j.profession;
/**
 * class Engineer extends base Profession.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Engineer extends Profession {
    private String category;

    /**
     * The call to the constructor of the base class with one param.
     * @param name engineer type String
     */
    Engineer(String name) {
        super(name);
    }

    /**
     * The call to the constructor of the base class with two param.
     * @param category type String, initialize a private variable
     */
    Engineer(String name, String surname, String category) {
        super(name, surname);
        this.category = category;
    }

    /**
     * method getCategory.
     * @return category engineer type String.
     */
    public String getCategory() {
        return category;
    }

    /**
     * method developing.
     * @return type Aviation.
     */
    public Aviation developing(Helicopter helicopter) {
        return new Aviation(getName(), helicopter.getModel());
    }
}
