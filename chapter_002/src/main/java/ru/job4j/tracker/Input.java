package ru.job4j.tracker;

/**
 * interface Input.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public interface Input {

    /**
     * Метод ask.
     * @param question вопрос
     * @return возвращает строку который ввел пользователь.
     */
    String ask(String question);

    /**
     * Метод ask.
     * @param question вопрос, диапозон меню
     * @param range диапозон меню
     */
    int ask(String question, int[] range);
}
