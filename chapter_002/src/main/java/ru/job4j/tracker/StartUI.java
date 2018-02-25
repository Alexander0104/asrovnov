package ru.job4j.tracker;

import ru.job4j.models.Item;

/**
 * class StartUI.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для показа всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
     * @param input ввод данных.
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
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                showAllItems();
            } else if (EDIT.equals(answer)) {
                editItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FINDBYID.equals(answer)) {
                findIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                findNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавления новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки : ");
        String description = this.input.ask("Введите описание заявки : ");
        String create = input.ask("Введите дату создания заявки : ");
//        input.enter();
        String comment = this.input.ask("Введите комментарий к заявке(если нет комментария нажмите Enter) : ");
        if (comment.equals("")) {
            Item item = new Item(name, description, create);
            this.tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        } else {
            Item item = new Item(name, description, create, comment);
            this.tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Метод реализует показ всех заявок в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Все заявки в хранилище --------------");
        Item[] allItems = tracker.findAll();
            for (int index = 0; index != allItems.length; index++) {
                if (allItems[index] != null) {
                    System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Дата создания: %s,  Kомментарий: %s",
                            allItems[index].getId(), allItems[index].getName(), allItems[index].getDescription(), allItems[index].getCreate(), allItems[index].getComment()));
                }
            }
//        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки  --------------");
        String id = this.input.ask("Введите ID заявки которую хотите заменить: ");
        String name = this.input.ask("Введите имя новой заявки : ");
        String description = this.input.ask("Введите описание новой заявки : ");
        String create = this.input.ask("Введите дату создания заявки : ");
//        input.enter();
        String comment = this.input.ask("\nВведите комментарий к новой заявке(если нет комментария нажмите Enter) : ");
        if (comment.equals("")) {
            Item item = new Item(name, description, create);
            this.tracker.replace(id, item);
        } else {
            Item item = new Item(name, description, create, comment);
            this.tracker.replace(id, item);
        }
    }

    /**
     * Метод реализует удаления заявки.
     */
    private void deleteItem() {
        String id = this.input.ask("Для удаления заявки введеите ее ID : ");
        tracker.delete(id);
    }

    /**
     * Метод реализует поиска заявки по ID.
     */
    private void findIdItem() {
        String key = this.input.ask("Введите ID заявки которую хотите найти: ");
        Item result = tracker.findById(key);
        System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s",
                result.getId(), result.getName(), result.getDescription()));
    }

    /**
     * Метод реализует поиска заявки по имени.
     */
    private void findNameItem() {
        String key = this.input.ask("Введите имя заявки которую хотите найти: ");
        Item[] result = tracker.findByName(key);
        for (int index = 0; index != result.length; index++) {
            if (result[index] != null) {
                System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s",
                        result[index].getId(), result[index].getName(), result[index].getDescription()));
            }
        }
    }

    private void showMenu() {
        System.out.println("\nМеню.\n"
                + "0. Добавить заявку.\n" 
                + "1. Показать все заявки.\n"
                + "2. Редактировать заявку.\n"
                + "3. Удалить заявку.\n"
                + "4. Поиск заявки по id.\n"
                + "5. Поиск заявок по имени.\n"
                + "6. Выход из программы.\n");
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

