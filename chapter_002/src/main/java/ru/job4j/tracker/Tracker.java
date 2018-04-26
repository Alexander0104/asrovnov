package ru.job4j.tracker;

import ru.job4j.models.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * base class Tracker.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class Tracker {

    /**
     * Срисок для хранение заявок.
     */
    private List<Item> items = new ArrayList<Item>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private static final Random RN = new Random();

    /**
     * Метод add.
     * Метод добавления заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод generateId.
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод findById.
     * Метод получения заявки по id.
     *
     * @param id заявки.
     * @return Возвращет найденую заявку, если заявка не найдена возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод findAll.
     * Метод получения всех заявок.
     * @return возвращает копию массива this.items без null элементов.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<Item>();
        for (Item item : items) {
            result.add(item);
        }
        return result;
    }

    /**
     * Метод findByName.
     * Метод получения списка по имени.
     * @param key имя заявки
     * @return возвращает копию массива this.items с key(именами).
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод replace.
     * Метод замены заявки по id.
     * @param id заявки
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        for (Item i : items) {
            if (i.getId().equals(id)) {
                item.setId(i.getId());
                items.remove(i);
                items.add(item);
                break;
            }
        }
    }

    /**
     * Метод delete.
     * Метод удаления заявки по id.
     * @param id заявки
     */
    public void delete(String id) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }
}
