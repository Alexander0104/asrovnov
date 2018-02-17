package ru.job4j.tracker;

import ru.job4j.models.Item;

import java.util.Random;

/**
 * base class Tracker.
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
     * Метод add.
     * Метод добавления заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод generateId.
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод findById.
     * Метод получения заявки по id.
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
     * Метод findById.
     * Метод получения заявки по id.
     * @return возвращает копию массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод findByName.
     * Метод получения списка по имени.
     * @param key имя заявки
     * @return возвращает копию массива this.items с key(именами).
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            if(items[index].getName().equals(key)) {
                result[index] = items[index];
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
        for (int index = 0; index !=this.position; index++) {
            if(items[index].getId().equals(id)) {
                item.setId(items[index].getId());
                items[index] = item;
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
        Item[] result = new Item[items.length];
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(items, 0, result, 0, index);
                System.arraycopy(items, index + 1, result, index, items.length - index - 1);
                items = result;
                break;
            }
        }

    }
}
