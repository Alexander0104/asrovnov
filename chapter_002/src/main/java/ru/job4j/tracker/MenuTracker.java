package ru.job4j.tracker;

import ru.job4j.models.*;

/**
 * class EditItem.
 * Класс реализует редактирование заявки в хранилище.
 */
class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки  --------------");
        String id = input.ask("Введите ID заявки которую хотите заменить: ");
        String name = input.ask("Введите имя новой заявки : ");
        String description = input.ask("Введите описание новой заявки : ");
        String create = input.ask("Введите дату создания заявки : ");
        String comment = input.ask("Введите комментарий к новой заявке(если нет комментария нажмите Enter) : ");
        if (comment.equals("")) {
            Item item = new Item(name, description, create);
            tracker.replace(id, item);
        } else {
            Item item = new Item(name, description, create, comment);
            tracker.replace(id, item);
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Редактировать заявку");
    }
}

/**
 * class FindIdItem.
 * Класс реализует поиск заявки в хранилище по ID.
 */
class FindIdItem implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String key = input.ask("Введите ID заявки которую хотите найти: ");
        Item result = tracker.findById(key);
        System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s", result.getId(), result.getName(), result.getDescription()));
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Поиск заявки по id.");
    }
}

/**
 * class Exit.
 * Класс реализует выход из MenuTracker.
 */
class Exit implements UserAction {

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Выход из программы.");
    }
}

/**
 * class MenuTracker.
 * Класс реализует события Tracker.
 */
public class MenuTracker {

    private  Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    /**
     * конструктор класса MenuTracker.
     * @param input данные введенные пользователем.
     * @param tracker хранилище заявок
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод заполнения массива actions.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindIdItem();
        this.actions[5] = new FindNameItem();
        this.actions[6] = new Exit();
    }

    /**
     * Метод выполняет действие выбранного пункта меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод вывода меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }

    /**
     * class AddItem.
     * Класс реализует добавления новой заявки в хранилище.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки : ");
            String description = input.ask("Введите описание заявки : ");
            String create = input.ask("Введите дату создания заявки : ");
            String comment = input.ask("Введите комментарий к заявке(если нет комментария нажмите Enter) : ");
            if (comment.equals("")) {
                Item item = new Item(name, description, create);
                tracker.add(item);
                System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
            } else {
                Item item = new Item(name, description, create, comment);
                tracker.add(item);
                System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
            }

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить заявку.");
        }
    }

    /**
     * class ShowAllItems.
     * Класс реализует вывод всех заявок в хранилище.
     */
    private static class ShowAllItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки в хранилище --------------");
            Item[] allItems = tracker.findAll();
            for (int index = 0; index != allItems.length; index++) {
                if (allItems[index] != null) {
                    System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s, Дата создания: %s,  Kомментарий: %s",
                            allItems[index].getId(), allItems[index].getName(), allItems[index].getDescription(), allItems[index].getCreate(), allItems[index].getComment()));
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки.");
        }
    }

    class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Для удаления заявки введеите ее ID : ");
            tracker.delete(id);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку.");
        }
    }

    /**
     * class FindNameItem .
     * Класс реализует поиск заявок в хранилище по имени.
     */
    private static class FindNameItem implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String key = input.ask("Введите имя заявки которую хотите найти: ");
            Item[] result = tracker.findByName(key);
            for (int index = 0; index != result.length; index++) {
                if (result[index] != null) {
                    System.out.println(String.format("ID заявки: %s, Имя заявки: %s, Описание: %s",
                            result[index].getId(), result[index].getName(), result[index].getDescription()));
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявок по имени.");
        }
    }
}
