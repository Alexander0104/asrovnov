package ru.job4j.tracker;

import ru.job4j.models.Item;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class StartUI.
 *
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class StartUITest {

    /**
     * Test
     * 0. Добавить заявку.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "Задача№1", "Починить компьтер", "23.02.2018", "Срочно", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Задача№1"));
    }

    /**
     * Test
     * 1. Добавить заявку.
     */
    @Test
    public void whenUserAddMoreItemThenTrackerShowAllItemName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Задача№2", "Протестировать ПО", "23.02.2018", "Срочно", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Задача№2"));
    }

    /**
     * Test
     * 2. Редактировать заявку.
     */
    @Test
    public void whenUserAddItemAndEditThenTrackerShowNewItemName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Задача№3", "Собрать компьютер", "23.02.2018", "Срочно"));
        Input input = new StubInput(new String[]{"2", item.getId(), "Задача№3.1", "Установить ПО на новый компьютер", "23.02.2018", "Срочно", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Задача№3.1"));
    }

    /**
     * Test
     * 3. Удалить заявку.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasItemNull() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Задача№4", "Настроить интернет", "23.02.2018", "Срочно"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item expected = null;
        assertThat(tracker.findAll()[0], is(expected));
    }

    /**
     * Test
     * 4. Поиск заявки по id.
     */
    @Test
    public void whenUserFindItemByIdThenThenTrackerHasItemDescription() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Задача№5", "Протестировать новый компьтер", "23.02.2018", "Срочно"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getDescription(), is("Протестировать новый компьтер"));
    }

    /**
     * Test_5
     * 5. Поиск заявок по имени.
     */
    @Test
    public void whenUserFindItemByNameThenTrackerHasNameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Задача№6", "Нет задачь", "23.02.2018"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        assertThat(tracker.findAll()[0].getName(), is("Задача№6"));
    }
}