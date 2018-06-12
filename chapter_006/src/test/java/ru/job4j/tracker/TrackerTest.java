package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class TrackerTest.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class TrackerTest {

    @After
    public void afterTest() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream reader = getClass().getClassLoader().getResourceAsStream("db_conf.properties")) {
            props.load(reader);
        }
        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("username"),
                props.getProperty("password")
        )) {
            conn.createStatement().execute("DROP TABLE tracker");
        }
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
            tracker.add(task);
            assertThat(tracker.findAll().get(0), is(task));
        }
    }

    /**
     * Test findById.
     */
    @Test
    public void whenAddIdInFindByIdThenTrackerGetItem() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
            tracker.add(task);
            assertThat(tracker.findById(task.getId()), is(task));
        }
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenAddNewItemThenTrackerGetAllItem() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            List<Item> tasks = new ArrayList<Item>();
            tasks.add(new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке"));
            tasks.add(new Item("Задача№2", "Исправить баг в программе", "12 : 00", "Не срочно"));
            for (Item task : tasks) {
                tracker.add(task);
            }
            assertThat(tracker.findAll(), is(tasks));
        }
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameAddKeyNameThenNewArrayItem() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
            tracker.add(task);
            assertThat(tracker.findByName("Задача№1").get(0), is(task));
        }
    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item previous = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
            tracker.add(previous);
            Item next = new Item("Задача№1(отредактирована)", "Собрать компьтер для нового сотрудника", "12 : 00");
            tracker.replace(previous.getId(), next);
            assertThat(tracker.findById(previous.getId()).getName(), is(next.getName()));
        }
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteAddIdThenSameItemDelete() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
            tracker.add(task);
            tracker.delete(task.getId());
            List<Item> expected = new ArrayList<Item>();
            assertThat(tracker.findAll(), is(expected));
        }
    }
}