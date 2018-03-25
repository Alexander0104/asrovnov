package ru.job4j.search;

import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class UserConvert.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class UserConvertTest {

    private static UserConvert userConvert;

    @Before
    public void beforeTest() {
        userConvert = new UserConvert();
        userConvert.add(new User(1, "Alexander", "SPB"));
    }

    /**
     * Test.
     * getUsers.
     */
    @Test
    public void whenListAddUserThenGetNameUserAlexander() {
        assertThat(userConvert.getUsers().get(0).getName(), is("Alexander"));
    }

    /**
     * Test.
     * process.
     */
    @Test
    public void whenProcessAddListUserThenGetNameUserAlexander() {
        HashMap<Integer, User> result = userConvert.process(userConvert.getUsers());
        assertThat(result.get(1).getName(), is("Alexander"));
    }
}