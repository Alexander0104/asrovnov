package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class Teacher.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TeacherTest {

    /**
     * Test getDegree.
     */
    @Test
    public void whenConstructorAddDegreeThenGetDegreeProfessor() {
        Teacher vladimir = new Teacher("Владимир", "Ивашков", "Professor");
        String result = vladimir.getDegree();
        assertThat(result, is("Professor"));
    }

    /**
     * Test teach.
     */
    @Test
    public void whenTeachAddNameStudentThenTeacherVladimirTeachAlexander() {
        Teacher vladimir = new Teacher("Владимир");
        Knowladge result = vladimir.teach(new Student("Александра"));
        String expected = "Преподаватель Владимир учит Александра";
        assertThat(result.getKnowladge(), is(expected));

    }
}