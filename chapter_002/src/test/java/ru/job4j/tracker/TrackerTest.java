package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.models.Item;

/**
 * Test class Tracker.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class TrackerTest {

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenAddIdInFindByIdThenTrackerGetItem() {
        Tracker tracker = new Tracker();
        Item task = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tracker.add(task);
        assertThat(tracker.findById(task.getId()), is(task));
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenAddNewItemThenTrackerGetAllItem() {
        Tracker tracker = new Tracker();
        Item[] tasks = new Item[2];
        tasks[0] = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tasks[1] = new Item("Задача№2", "Исправить баг в программе", 12L, "Не срочно");
        for (int index = 0; index != tasks.length; index++) {
            tracker.add(tasks[index]);
        }
        assertThat(tracker.findAll(), is(tasks));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameAddKeyNameThenSameItem() {
        Tracker tracker = new Tracker();
        Item task = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tracker.add(task);
        Item[] expected = tracker.findByName("Задача№1");
        assertThat(tracker.findByName("Задача№1"), is(expected));
    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tracker.add(previous);
        Item next = new Item("Задача№1(отредактирована)","Собрать компьтер для нового сотрудника",1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is(next.getName()));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteAddIdThenSameItemDelete() {
        Tracker tracker = new Tracker();
        Item task = new Item("Задача№1", "Отремонтировать компьютер", 10L, "В срочном порядке");
        tracker.add(task);
        tracker.delete(task.getId());
        Item[] expected = new Item[1];
        expected[0] = null;
        assertThat(tracker.findAll(), is(expected));
    }
}