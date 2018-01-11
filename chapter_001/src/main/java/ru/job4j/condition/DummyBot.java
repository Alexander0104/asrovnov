package ru.job4j.condition;


/**
 * Class DummyBot.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {

        String reply = "Это ставит меня в тупик. Спросите другой вопрос.";

        if ("Привет, Бот.".equals(question)) {
            reply = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            reply = "До скорой встречи.";
        }
        return reply;
    }

}
