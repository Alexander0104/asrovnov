package ru.job4j.tracker;

import ru.job4j.models.Item;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;

/**
 * Test class StartUI.
 *
 * @author Alexander Rovnov
 * @version 1.1
 * @since 1.1
 */
public class StartUITest {

    static Tracker tracker;
    static Item item;

    @Before
    public void beforeTest() {
        tracker = new Tracker();
        item = new Item("Задача№1", "Починить компьтер", "23.02.2018", "Срочно");
        tracker.add(item);
    }

    /**
     * Test
     * 0. Добавить заявку.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "Задача№1", "Починить компьтер", "23.02.2018", "Срочно", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
    }

    /**
     * Test
     * 1. Показать все заявки.
     */
    @Test
    public void whenUserAddMoreItemThenTrackerShowAllItemName() {
        Input input = new StubInput(new String[]{"0", "Задача№1", "Починить компьтер", "23.02.2018", "Срочно", "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
    }

    /**
     * Test
     * 2. Редактировать заявку.
     */
    @Test
    public void whenUserAddItemAndEditThenTrackerShowNewItemName() {
        Input input = new StubInput(new String[]{"2", item.getId(), "Задача№1.1", "Установить ПО на новый компьютер", "23.02.2018", "Срочно", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("Задача№1.1"));
    }

    /**
     * Test
     * 3. Удалить заявку.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasItemNull() {
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new ArrayList<Item>()));
    }

    /**
     * Test
     * 4. Поиск заявки по id.
     */
    @Test
    public void whenUserFindItemByIdThenThenTrackerHasItemDescription() {
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getDescription(), is("Починить компьтер"));
    }

    /**
     * Test_5
     * 5. Поиск заявок по имени.
     */
    @Test
    public void whenUserFindItemByNameThenTrackerHasNameItem() {
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("Задача№1"));
    }
}