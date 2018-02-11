package ru.job4j.profession;
/**
 * class Knowladge.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Knowladge {
   private String teacher, student;

    /**
     * constructor have two param.
     * @param teacher type String
     * @param student type String
     */
    Knowladge(String teacher, String student) {
        this.teacher = teacher;
        this.student = student;
    }

    /**
     * method getTeacher.
     * @return teacher name type String.
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * method getTeacher.
     * @return student name type String.
     */
    public String getStudent() {
        return student;
    }

    /**
     * method getKnowladge.
     * @return type String.
     */
    public String getKnowladge() {
        return String.format("Преподаватель %s учит %s", getTeacher(), getStudent());
    }
}
