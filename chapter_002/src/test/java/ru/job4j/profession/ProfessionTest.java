package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class Profession.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class ProfessionTest {

    /**
     * Test getName.
     */
    @Test
    public void whenConstructorProfessionAddNameAndSurnameThenGetNameVladimir() {
        Profession teacher = new Profession("Vladimir", "Ivashkiv");
        assertThat(teacher.getName(), is("Vladimir"));
        }

    /**
     * Test getSurname.
     */
    @Test
    public void whenConstructorProfessionAddNameAndSurnameThenGetSurnameIvashkiv() {
        Profession teacher = new Profession("Vladimir", "Ivashkiv");
        assertThat(teacher.getSurname(), is("Ivashkiv"));
    }
}
