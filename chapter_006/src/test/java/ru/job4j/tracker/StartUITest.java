package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class StartUI.
 * @author Alexander Rovnov
 * @version 1.2
 * @since 1.2
 */
public class StartUITest {

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
     * Test
     * 0. Добавить заявку.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Input input = new StubInput(new String[]{"0", "Задача№1", "Починить компьтер", "23.02.2018", "Срочно", "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
        }
    }

    /**
     * Test
     * 1. Показать все заявки.
     */
    @Test
    public void whenUserAddMoreItemThenTrackerShowAllItemName() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Input input = new StubInput(new String[]{"0", "Задача№1", "Починить компьтер", "23.02.2018", "Срочно", "1", "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
        }
    }

    /**
     * Test
     * 2. Редактировать заявку.
     */
    @Test
    public void whenUserAddItemAndEditThenTrackerShowNewItemName() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item item = tracker.add(new Item("Задача№1", "Починить компьтер", "23.02.2018", "Срочно"));
            Input input = new StubInput(new String[]{"2", item.getId(), "Задача№1.1", "Установить ПО на новый компьютер", "23.02.2018", "Срочно", "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll().get(0).getName(), is("Задача№1.1"));
        }
    }

    /**
     * Test
     * 3. Удалить заявку.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasItemNull() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item item = tracker.add(new Item("Задача№1", "Починить компьтер", "23.02.2018", "Срочно"));
            Input input = new StubInput(new String[]{"3", item.getId(), "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll(), is(new ArrayList<Item>()));
        }
    }

    /**
     * Test
     * 4. Поиск заявки по id.
     */
    @Test
    public void whenUserFindItemByIdThenThenTrackerHasItemDescription() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item item = tracker.add(new Item("Задача№1", "Починить компьтер", "23.02.2018", "Срочно"));
            Input input = new StubInput(new String[]{"4", item.getId(), "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll().get(0).getDescription(), is("Починить компьтер"));
        }
    }

    /**
     * Test_5
     * 5. Поиск заявок по имени.
     */
    @Test
    public void whenUserFindItemByNameThenTrackerHasNameItem() {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            Item item = tracker.add(new Item("Задача№1", "Починить компьтер", "23.02.2018", "Срочно"));
            Input input = new StubInput(new String[]{"5", item.getName(), "6"});
            new StartUI(input, tracker).init();
            assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
        }
    }
}