package ru.job4j.tracker;

/**
 * interface Input.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public interface Input {

    /**
     * Метод ask.
     * @param question вопрос
     * @return возвращает строку который ввел пользователь.
     */
    String ask(String question);

    String enter();

    /**
     * Метод ask.
     * @param question вопрос
     * @return возвращает строку который ввел пользователь.
     */
    long date(String question);


}
