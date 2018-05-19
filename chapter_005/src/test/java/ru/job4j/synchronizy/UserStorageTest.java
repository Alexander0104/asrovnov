package ru.job4j.synchronizy;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class UserStorageTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class UserStorageTest {

    private UserStorage storage;

    @Before
    public void beforeTest() {
        storage = new UserStorage();
    }

    /**
     * Test_01.
     * Добавляем первых двух пользователей в первом потоке threadOne
     * и остальных двух пользователей во втором потоке threadTwo.
     */
    @Test
    public void whenAddFourUserUseTwoThread() {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.add(new User(0, 10));
                storage.add(new User(1, 20));
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.add(new User(2, 30));
                storage.add(new User(3, 40));
            }
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(storage.getStorage().get(0).getAmount(), is(10));
        assertThat(storage.getStorage().get(1).getAmount(), is(20));
        assertThat(storage.getStorage().get(2).getAmount(), is(30));
        assertThat(storage.getStorage().get(3).getAmount(), is(40));

    }

    /**
     * Test_02.
     * Добавляем четырех пользователей в первом потоке threadOne
     * и удаляем последних двух пользователей во втором потоке threadTwo.
     */
    @Test
    public void whenDeleteThenResultSizeTwo() {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.add(new User(0, 10));
                storage.add(new User(1, 20));
                storage.add(new User(2, 30));
                storage.add(new User(3, 40));
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                storage.delete(new User(2, 30));
                storage.delete(new User(3, 40));
            }
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(storage.getStorage().get(0).getAmount(), is(10));
        assertThat(storage.getStorage().get(1).getAmount(), is(20));
        assertThat(storage.getStorage().size(), is(2));
    }

    /**
     * Test_03.
     * update.
     */
    @Test
    public void whenUpdateThenTrue() {
        storage.add(new User(0, 10));
        storage.add(new User(0, 20));
        assertThat(storage.update(new User(0, 20)), is(true));
        assertThat(storage.getStorage().get(0).getAmount(), is(20));
    }

    /**
     * Test_03.
     * transfer.
     */
    @Test
    public void whenTransferThenTrue() {
        User first = new User(0, 10);
        User second = new User(1, 20);
        storage.add(first);
        storage.add(second);
        assertThat(storage.transfer(first.getId(), second.getId(), 5), is(true));
        assertThat(storage.getStorage().get(0).getAmount(), is(5));
        assertThat(storage.getStorage().get(1).getAmount(), is(25));
    }
}