package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class UserConvert.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SortUserTest {

    private static List<User> users;
    private static SortUser sort;

    @Before
    public void beforeTest() {
        users = new ArrayList<User>();
        sort = new SortUser();
    }

    /**
     * Test.
     * Метод sort.
     */
    @Test
    public void whenInSortAddListUsersThenAgeFifteen() {
        users.add(new User("Sasha", 30));
        users.add(new User("Vova", 25));
        users.add(new User("Artur", 15));
        Set<User> result = sort.sort(users);
        assertThat(result.iterator().next().getAge(), is(15));
    }

    /**
     * Test.
     * Метод sortNameLength.
     */
    @Test
    public void whenInSortNameLengthAddListUsersThenVovaArturAlexander() {
        users.add(new User("Alexander", 30));
        users.add(new User("Vova", 25));
        users.add(new User("Artur", 15));
        List<User> result = sort.sortNameLength(users);
        List<User> expected = Arrays.asList(
                new User("Vova", 25),
                new User("Artur", 15),
                new User("Alexander", 30)
        );
        assertThat(result, is(expected));
    }

    /**
     * Test.
     * Метод sortByAllFields.
     */
    @Test
    public void whenInSortByAllFieldsAddListUsersThenSortAllField() {
        users.add(new User("Alexander", 35));
        users.add(new User("Artur", 20));
        users.add(new User("Alexander", 30));
        users.add(new User("Artur", 15));
        List<User> result = sort.sortByAllFields(users);
        List<User> expected = Arrays.asList(
                new User("Alexander", 30),
                new User("Alexander", 35),
                new User("Artur", 15),
                new User("Artur", 20)
        );
        assertThat(result, is(expected));
    }
}