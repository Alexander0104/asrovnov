package ru.job4j.tracker;

import java.util.Objects;

/**
 * base class Item.
 * Класс создания заявки.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Item {

    /**
     * Поля состояния объекта Item
     */
    private String id;
    private String name;
    private String description;
    private String create;
    private String comment;

    /**
     * Конструктор с тремя параметрами.
     * @param name имя заявки.
     * @param description описание заявки.
     * @param create время создание заявки.
     */
    public Item(String name, String description, String create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Конструктор с четырьмя параметрами.
     * @param name имя заявки.
     * @param description описание заявки.
     * @param create время создание заявки.
     * @param comment комментарий к заявке.
     */
    public Item(String name, String description, String create, String comment) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }

    /**
     * Метод getName.
     * @return возвращает имя заяки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод getDescription.
     * @return возвращает описание заявки.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Метод getCreate.
     * @return возвращает время создания заявки.
     */
    public String getCreate() {
        return this.create;
    }

    /**
     * Метод getComment.
     * @return возвращает комментарий к заявке.
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Метод getId.
     * @return возвращает id заявки.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Метод setId устанавливает id заявки.
     * @param id заявки.
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item {"
                + "id = '" + id + '\''
                + ", name = '" + name + '\''
                + ", description = '" + description + '\''
                + ", create = '" + create + '\''
                + ", comment = '" + comment + '\''
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
        return Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description)
                && Objects.equals(create, item.create)
                && Objects.equals(comment, item.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
