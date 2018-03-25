package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class Tracker.
 *
 * @author Alexander Rovnov
 * @version 1.1
 * @since 1.1
 */
public class TrackerTest {

    static Tracker tracker;

    @Before
    public void beforeTest() {
        tracker = new Tracker();
    }

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
        tracker.add(task);
        assertThat(tracker.findAll().get(0), is(task));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenAddIdInFindByIdThenTrackerGetItem() {
        Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
        tracker.add(task);
        assertThat(tracker.findById(task.getId()), is(task));
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenAddNewItemThenTrackerGetAllItem() {
        List<Item> tasks = new ArrayList<Item>();
        tasks.add(new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке"));
        tasks.add(new Item("Задача№2", "Исправить баг в программе", "12 : 00", "Не срочно"));
        for (Item task : tasks) {
            tracker.add(task);
        }
        assertThat(tracker.findAll(), is(tasks));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameAddKeyNameThenNewArrayItem() {
        Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
        tracker.add(task);
        assertThat(tracker.findByName("Задача№1").get(0), is(task));

    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
        tracker.add(previous);
        Item next = new Item("Задача№1(отредактирована)", "Собрать компьтер для нового сотрудника", "12 : 00");
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is(next.getName()));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteAddIdThenSameItemDelete() {
        Item task = new Item("Задача№1", "Отремонтировать компьютер", "12 : 00", "В срочном порядке");
        tracker.add(task);
        tracker.delete(task.getId());
        List<Item> expected = new ArrayList<Item>();
        assertThat(tracker.findAll(), is(expected));
    }
}