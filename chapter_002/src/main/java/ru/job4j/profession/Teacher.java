package ru.job4j.profession;
/**
 * class Teacher extends base Profession.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Teacher extends Profession {
    private String degree;

    /**
     * The call to the constructor of the base class with one param.
     * @param name teacher type String
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * The call to the constructor of the base class with two param.
     * @param degree type String, initialize a private variable
     */
    public Teacher(String name, String surname, String degree) {
        super(name, surname);
        this.degree = degree;
    }

    /**
     * method getDegree.
     * @return degree teacher type String.
     */
    public String getDegree() {
        return degree;
    }

    /**
     * method teach.
     * @return type Knowladge.
     */
    public Knowladge teach(Student student) {
        return new Knowladge(getName(), student.getName());
    }
}
