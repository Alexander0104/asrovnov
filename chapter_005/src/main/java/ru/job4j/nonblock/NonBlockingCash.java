package ru.job4j.nonblock;
import java.util.concurrent.ConcurrentHashMap;

/**
 * class NonBlockingCash.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class NonBlockingCash {

    /**
     * Кеш.
     */
    private ConcurrentHashMap<Integer, Model> storage = new ConcurrentHashMap<>();

    /**
     * Метод add.
     * Метод добавления в кеш.
     * @param key ключ.
     * @param model модел.
     */
    public void add(Integer key, Model model) {
        storage.putIfAbsent(key, model);
    }

    /**
     * Метод update.
     * Обновляет модель в кеше.
     * @param key ключ модели.
     * @param model модель с новыми параметрами.
     */
    public void update(Integer key, Model model) throws OptimisticException {
        this.storage.computeIfPresent(key, (k, v) -> {
            if (v.getVersion() == model.getVersion()) {
                model.change(model.getName());
                model.setValue(model.getValue());
                return model;
            } else {
                throw new OptimisticException("OptimisticException exception");
            }
        });
    }

    /**
     * Метод delete.
     * Удаляет модель из кеша.
     * @param key ключ модели.
     */
    public void delete(Integer key) {
        this.storage.remove(key);
    }

    /**
     * Метод get.
     * Возвращает модель.
     * @param key ключ модели.
     */
    public Model get(Integer key) {
        return this.storage.get(key);
    }
}
