package ru.job4j.tracker;

/**
 * Abstract class BaseAction.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public abstract class BaseAction implements UserAction {


    private final int key;
    private final String name;

    /**
     * Конструтор инициализирующий поля.
     * @param key пунк меню.
     * @param name название меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Метод key.
     * Метод запроса у пользователя ключа(действие которое он хочет выполнить).
     * @return номер выбронного пункта меню.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод info.
     * Метод вывода пункта меню.
     * @return номер и описания пункта меню
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
