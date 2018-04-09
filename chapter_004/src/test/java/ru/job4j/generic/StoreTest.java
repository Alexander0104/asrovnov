package ru.job4j.generic;

import org.junit.Test;

import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test interface Store.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class StoreTest {

    private static Store<User> userStore;
    private static Store<Role> roleStore;
    private static User user;
    private static Role role;

    @Before
    public void beforeTest() {
        userStore = new UserStore(new SimpleArray<>(5));
        roleStore = new RoleStore(new SimpleArray<>(5));
        user = new User("1");
        role = new Role("Программист");
        userStore.add(user);
        roleStore.add(role);

    }

    /**
     * Test.
     * findById.
     */
    @Test
    public void whenAddUserAndRoleThenId() {
        assertThat(userStore.findById("1"), is(user));
        assertThat(roleStore.findById("Программист"), is(role));
    }

    /**
     * Test.
     * replace.
     */
    @Test
    public void whenReplaceAddAdAndModelThenTrue() {
        assertThat(userStore.replace("1", new User("2")), is(true));
        assertThat(roleStore.replace("Программист", new Role("Инженер")), is(true));
    }

    /**
     * Test.
     * delete.
     */
    @Test
    public void whenDeleteAddIdThenTrue() {
        assertThat(userStore.delete("1"), is(true));
        assertThat(roleStore.delete("Программист"), is(true));
    }

}