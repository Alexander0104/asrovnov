package ru.job4j.synchronizy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * class UserStorage.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class UserStorage {

    /**
     * Хранилище.
     */
    @GuardedBy("this")
    private ArrayList<User> list = new ArrayList<>();

    /**
     * Метод add.
     * Метод добавляет пользователя в хранилище.
     * @param user пользователь.
     */
    public synchronized boolean add(User user) {
        return list.add(user);
    }

    /**
     * Метод add.
     * Метод удаляет пользователя из хранилище.
     * @param user пользователь.
     */
    public synchronized boolean delete(User user) {
        return list.remove(user);
    }

    /**
     * Метод update.
     * Метод добавляет пользователя в хранилище.
     * @param user пользователь.
     * @return true если обновление прошло успешно,
     *         false если обновление не удалось.
     */
    public synchronized boolean update(User user) {
        boolean result = false;
        int count = 0;
        for (User index : this.list) {
            if (index != null && index.getId() == user.getId()) {
                list.set(count, user);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Метод transfer.
     * Метод добавляет пользователя в хранилище.
     * @param fromId id пользователя у котороко вычитаем сумму.
     * @param toId id пользователя которому добавляем сумму.
     * @param amount сумма.
     * @return true если transfer прошел успешно,
     *         false если transfer прошел не успешно.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        Collections.sort(list);
        if (list.get(fromId).getId() == fromId && list.get(toId).getId() == toId) {
            update(new User(fromId, list.get(fromId).getAmount() - amount));
            update(new User(toId, list.get(toId).getAmount() + amount));
            result = true;
        }
        return result;
    }

    /**
     * Метод getStorage.
     * @return хранилище.
     */
    public synchronized List<User> getStorage() {
        return this.list;

    }
}
