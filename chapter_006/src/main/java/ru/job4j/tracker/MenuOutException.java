package ru.job4j.tracker;

/**
 * class MenuOutException наследуемый от RuntimeException.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class MenuOutException extends RuntimeException {

    /**
     * Конструтор класса MenuOutException.
     * @param msg сообщение ою ошибке.
     */
    public MenuOutException(String msg) {
        super(msg);
    }

}
