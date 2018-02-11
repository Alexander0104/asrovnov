package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class Doctor.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class DoctorTest {

    /**
     * Test getDirection.
     */
    @Test
    public void whenConstructorAddDirectionThenGetDirectionSurgeon() {
        Doctor alexander = new Doctor("Александр", "Ивашков", "Surgeon");
        String result = alexander.getDirection();
        assertThat(result, is("Surgeon"));

    }

    /**
     * Test cure.
     */
    @Test
    public void whenCureAddNameTeacherThenDoctorAlexanderCureVladimir() {
        Doctor alexander = new Doctor("Александр");
        Healthcare result = alexander.cure(new Teacher("Владимира"));
        String expected = "Доктор Александр лечит Владимира";
        assertThat(result.getHealthcare(), is(expected));
    }
}