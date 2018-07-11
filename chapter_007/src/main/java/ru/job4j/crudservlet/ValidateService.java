package ru.job4j.crudservlet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * class ValidateService.
 * @author Alexander Rovnov.
 * @version 1.3
 * @since 1.3
 */
public class ValidateService {

    private final static ValidateService INSTANCE  = new ValidateService();
    private final Store store;

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
        boolean result = false;
        if (user != null
                && user.getName() != null
                && user.getLogin() != null
                && user.getEmail() != null
                && !user.getName().equals("")
                && !user.getLogin().equals("")
                && !user.getEmail().equals("")) {
            Calendar currentDate = new GregorianCalendar();
            currentDate.setTime(new Date());
            user.setCreateDate(currentDate);
            this.store.add(user);
            result = true;
        }
        return result;
    }

    /**
     * Метод update.
     * @param user пользователь.
     * @return true, если обновлени прошло успешно,
     *         false, если не удалось обновить.
     */
    public boolean update(User user) {
        boolean result = false;
        if (this.store.findById(user.getId()) != null
                && user.getEmail() != null) {
            this.store.update(user);
            result = true;
        }
        return result;
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
    public List<User> findAll() {
        return this.store.findAll();
    }

    /**
     * Метод findById.
     * @param id пользователя.
     * @return возвращает пользователя,
     *         null в случае отсутствия.
     */
    public User findById(int id) {
        return this.store.findById(id);
    }
}
