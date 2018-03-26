package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

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

    /**
     * Test.
     * Метод sort.
     */
    @Test
    public void whenInSortAddListUserThenAgeFifteen() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Sasha", 30));
        users.add(new User("Vova", 25));
        users.add(new User("Artur", 15));
        SortUser ageSort = new SortUser();
        Set<User> result = ageSort.sort(users);
        assertThat(result.iterator().next().getAge(), is(15));
    }
}