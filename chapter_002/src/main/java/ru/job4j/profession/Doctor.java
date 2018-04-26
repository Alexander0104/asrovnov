package ru.job4j.profession;
/**
 * class Doctor extend Profession.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Doctor extends Profession {
    private String direction;

    /**
     * The call to the constructor of the base class with one param.
     * @param name doctor type String
     */
    public Doctor(String name) {
        super(name);
    }

    /**
     * The call to the constructor of the base class with two param.
     * @param direction type String, initialize a private variable
     */
    public Doctor(String name, String surname, String direction) {
        super(name, surname);
        this.direction = direction;
    }

    /**
     * method getDirection.
     * @return direction doctor type String.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * method cure.
     * @return type Healthcare.
     */
    public Healthcare cure(Teacher teacher) {
        return new Healthcare(getName(), teacher.getName());
    }
}
