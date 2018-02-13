package ru.job4j.tracker;

import ru.job4j.models.Item;

import java.util.Random;

/**
 * class Tracker.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод получения заявки по id.
     * @param id заявки.
     * @return заявку.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
//
//    public void replase(String id, Item item) {
//
//    }
//
//    public void delete(String id) {
//
//    }
//
//    public Item[] findAll() {
//
//    }
//
//    public Item[] findByName(String key) {
//
//    }

}
