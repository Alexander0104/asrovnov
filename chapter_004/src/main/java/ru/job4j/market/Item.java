package ru.job4j.market;

import java.util.Objects;

/**
 * class Item.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Item implements Comparable<Item> {

    public enum Type {
       ADD, DELETE
    }

    /**
     * Уникальный ключ заявки.
     */
    private final int id;

    /**
     * Идентификатор ценной бумаги.
     */
    private final String book;

    /**
     * Выставить заявку на торги или снять.
     */
    private final Type type;

    /**
     * Покупка или продажа ценной бумаги.
     */
    private final String action;

    /**
     * Цена.
     */
    private final int price;

    /**
     * Количество акций, которые мы хотим продать или купить.
     */
    private int volume;

    /**
     * Конструктор класс Item.
     */
    public Item(int id, String book, Type type, String action, int price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Метод getId.
     * @return уникальный ключ заявки.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод getBook.
     * @return идентификатор ценной бумаги.
     */
    public String getBook() {
        return book;
    }

    /**
     * Метод getType.
     * @return выставить заявку на торги или снять.
     */
    public Type getType() {
        return type;
    }

    /**
     * Метод getAction.
     * @return покупку или продажу ценной бумаги.
     */
    public String getAction() {
        return action;
    }

    /**
     * Метод getPrice.
     * @return цену.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Метод getVolume.
     * @return Количество акций, которые мы ходим продать или купить.
     */
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Item {"
                + "id = " + id
                + ", book = '" + book + '\''
                + ", type = '" + type + '\''
                + ", action = '" + action + '\''
                + ", price = " + price
                + ", volume = " + volume
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && book.equals(item.book)
                && type.equals(item.type)
                && action.equals(item.action)
                && price == item.price
                && volume == item.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Переопределенный метод compareTo.
     * Сортирует по убыванию цены.
     */
    @Override
    public int compareTo(Item o) {
        return -Integer.compare(this.getPrice(), o.getPrice());
    }
}
