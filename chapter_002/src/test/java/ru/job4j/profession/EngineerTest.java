package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class Engineer.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class EngineerTest {

    /**
     * Test getCategory.
     */
    @Test
    public void whenConstructorAddCategoryThenGetCategoryPrincipal() {
        Engineer vladimir = new Engineer("Владимир", "Ивашков", "Ведущий");
        String result = vladimir.getCategory();
        assertThat(result, is("Ведущий"));
    }

    /**
     * Test developing.
     */
    @Test
    public void whenDevelopingAddModelHelicopterThenEngineerDevelopingMi8() {
        Engineer vladimir = new Engineer("Владимир");
        Aviation result = vladimir.developing(new Helicopter("Ми-8"));
        String expected = "Инженер Владимир разрабатывает Ми-8";
        assertThat(result.getAviation(), is(expected));
    }
}