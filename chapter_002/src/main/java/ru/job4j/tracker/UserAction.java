package ru.job4j.tracker;

/**
 * interface UserAction.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public interface UserAction {

    /**
     * Метод key.
     * Метод запроса у пользователя ключа(действие которое он хочет выполнить).
     * @return номер выбронного пункта меню.
     */
    int key();

    /**
     * Метод execute.
     * Метод выполнения действия, выбранного пользователем в меню.
     * @param input данные введенные пользователем.
     * @param tracker хранилище заявок
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод info.
     * Метод вывода пункта меню.
     * @return номер и описания пункта меню
     */
    String info();
}
