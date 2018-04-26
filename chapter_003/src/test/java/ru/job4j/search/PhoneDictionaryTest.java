package ru.job4j.search;

import org.junit.Test;
import org.junit.Before;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class PhoneDictionary.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class PhoneDictionaryTest {

    static PhoneDictionary phones;

    @Before
    public void beforeTest() {
        phones = new PhoneDictionary();
        phones.add(new Person("Alexander", "Ivashkov", "9213434", "SPB"));
    }

    /**
     * Test_01
     * add.
     */
    @Test
    public void whenAddNewPersonThenGetName() {
        assertThat(phones.find("Alexander").iterator().next().getName(), is("Alexander"));
    }

    /**
     * Test_02
     * find.
     */
    @Test
    public void whenFindByNameThenSurname() {
        List<Person> persons = phones.find("Alexander");
        assertThat(persons.iterator().next().getSurname(), is("Ivashkov"));
    }
}