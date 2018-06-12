package ru.job4j.tracker;

/**
 * class StartUI.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!exit) {
            menu.show();
            int key = this.input.ask("\nВведите пункт меню : ", menu.getRange());
            menu.select(key);
            if ("6".equals(String.valueOf(key))) {
                exit = true;
            }
        }
    }

    /**
     * Запуск программы.
     *
     * @param args .
     */
    public static void main(String[] args) {
        try (Tracker tracker = new Tracker()) {
            tracker.init();
            new StartUI(new ValidateInput(new ConsoleInput()), tracker).init();
        }
    }
}

