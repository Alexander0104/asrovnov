package ru.job4j.tracker;

/**
 * class StubInput.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class StubInput implements Input {

    /**
     * Поле содержит последовательность ответов пользователя.
     */
    private final String[] value;
    /**
     * Поле считает количество вызовом метода ask.
     */
    private int position = 0;

    /**
     * Конструктор класса StubInput с одним параметром.
     * @param value последовательность ответов пользователя.
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Метод ask.
     * @param question вопрос
     * @return при вызове возвращает новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, int[] range){
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Ошибка ввода: Выход из диапазона меню");
        }
    }
}
