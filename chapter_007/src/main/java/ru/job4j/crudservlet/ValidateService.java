package ru.job4j.crudservlet;

import java.util.Collection;
import java.util.Collections;

/**
 * class ValidateService.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ValidateService {

    private final static ValidateService INSTANCE  = new ValidateService();
//        private final Store store = MemoryStore.getInstance();
    private Store store;

    private ValidateService() {
        store = DBStore.getInstance();
    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * Метод add.
     * @param user пользователь.
     * @return true, если пользователь добавлен,
     *         false, если не удалось добавить.
     */
    public boolean add(User user) {
        if (store.findById(user.getId()) == null) {
            store.add(user);
            return true;
        }
        return false;
    }

    /**
     * Метод update.
     * @param user пользователь.
     * @return true, если обновлени прошло успешно,
     *         false, если не удалось обновить.
     */
    public boolean update(User user) {
        if (store.findById(user.getId()) != null) {
            store.update(user);
            return true;
        }
        return false;
    }

    /**
     * Метод delete.
     * @param id пользователь.
     * @return true, если удаление прошло успешно,
     *         false, если не удалось удалить.
     */
    public boolean delete(int id) {
        if (store.findById(id) != null) {
            store.delete(id);
            return true;
        }
        return false;
    }

    /**
     * Метод findAll.
     * @return возвращает всех пользователей в коллекции.
     */
    public Collection<User> findAll() {
        if (!store.findAll().isEmpty()) {
            return store.findAll();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Метод findById.
     * @param id пользователя.
     * @return возвращает пользователя,
     *         null в случае отсутствия.
     */
    public User findById(int id) {
        return store.findById(id);
    }
}
